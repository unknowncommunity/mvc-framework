package ua.uc.framework.mappers;

import ua.uc.framework.model.RequestMethod;
import ua.uc.framework.model.meta.ParamMeta;
import ua.uc.framework.model.meta.URLMeta;

import java.lang.reflect.Method;

/**
 * Created by kostya on 23.06.15.
 */
public class URLMetaMapper implements Mapper<Method, URLMeta> {
    public URLMetaMapper() {}

    @Override
    public URLMeta map(Method method) {
        return new URLMeta(method.getName(),  method.getReturnType(), RequestMethod.GET);
    }
}
