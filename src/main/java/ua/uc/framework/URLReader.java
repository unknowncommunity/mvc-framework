package ua.uc.framework;

import ua.uc.framework.mappers.Mapper;
import ua.uc.framework.mappers.URLMetaMapper;
import ua.uc.framework.model.meta.ParamMeta;
import ua.uc.framework.model.meta.URLMeta;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Tradunsky V.V.
 */
public class URLReader {
    private Mapper<Method, URLMeta> urlMetaMapper;

    public URLReader() {
        urlMetaMapper = new URLMetaMapper();
    }


    public List<URLMeta> processClassURL(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods)
                .filter(m -> Modifier.isPublic(m.getModifiers()))
                .map(urlMetaMapper::map)
                .collect(toList());
    }
}
