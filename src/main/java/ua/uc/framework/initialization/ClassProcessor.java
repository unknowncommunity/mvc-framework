package ua.uc.framework.initialization;

import ua.uc.framework.URLReader;
import ua.uc.framework.holders.meta.URLMetaHolder;
import ua.uc.framework.holders.processors.ProcessorsHolder;
import ua.uc.framework.initialization.util.ClassUtil;
import ua.uc.framework.mappers.RequestProcessorMapper;
import ua.uc.framework.mappers.URLMetaMapper;
import ua.uc.framework.model.meta.URLMeta;
import ua.uc.framework.processors.request.RequestProcessor;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kostya on 25.06.15.
 */
public class ClassProcessor {
    private URLMetaHolder urlMetaHolder = URLMetaHolder.get();
    private ProcessorsHolder processorsHolder = ProcessorsHolder.get();

    private URLReader urlReader;
    private URLMetaMapper urlMetaMapper;

    public ClassProcessor() {
        urlReader = new URLReader();
        urlMetaMapper = new URLMetaMapper();
    }
    public void process(Class controllerClass) {
        Object controllerObj = instantiateController(controllerClass);
        if (controllerObj == null) return ;

        RequestProcessorMapper requestProcessorMapper = new RequestProcessorMapper(controllerObj);
        Collection<Method> publicMethods = ClassUtil.getPublicMethods(controllerClass);
        Collection<URLMeta> urlMetaCollection = new ArrayList<>();
        for (Method publicMethod: publicMethods) {
            URLMeta urlMeta = urlMetaMapper.map(publicMethod);
            RequestProcessor requestProcessor = requestProcessorMapper.map(publicMethod);
            processorsHolder.put(urlMeta, requestProcessor);
            urlMetaCollection.add(urlMeta);
        }

        Map<String, List<URLMeta>> urlMetaGroupedByUri = urlMetaCollection.stream().collect(Collectors.groupingBy(urlMeta -> urlMeta.getUriPath()));
        urlMetaHolder.putAll(urlMetaGroupedByUri);
    }

    private Object instantiateController(Class controllerClass) {
        try {
            return controllerClass.newInstance();
        } catch (Exception e) {

        }
        return null;
    }
}
