package ua.uc.framework.mappers;

import ua.uc.framework.model.meta.ParamMeta;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by kostya on 23.06.15.
 */
public class ParamMetaMapper implements Mapper<Method, ParamMeta[]> {
    @Override
    public ParamMeta[] map(Method method) {
        Parameter[] parameters = method.getParameters();
        ParamMeta[] paramsMetas = new ParamMeta[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            paramsMetas[i] = new ParamMeta(parameters[i].getName(), parameters[i].getType());
        }
        return paramsMetas;
    }
}
