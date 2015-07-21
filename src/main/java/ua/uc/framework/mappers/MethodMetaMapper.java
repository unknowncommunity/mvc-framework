package ua.uc.framework.mappers;

import ua.uc.framework.model.meta.MethodMeta;
import ua.uc.framework.model.meta.ParamMeta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostya on 21.07.15.
 */
public class MethodMetaMapper implements Mapper<Method, MethodMeta> {

    @Override
    public MethodMeta map(Method method) {
        Parameter[] parameters = method.getParameters();
        List<ParamMeta> paramsMetas = new ArrayList<>();
        ParamMeta requestMeta = null;
        ParamMeta responseMeta = null;

        for (int position = 0; position < parameters.length; position++) {
            Parameter parameter = parameters[position];

            if (parameter.getType().isAssignableFrom(HttpServletRequest.class)) {
                requestMeta = toParamMeta(parameter, position);
                continue;
            }
            if (parameter.getType().isAssignableFrom(HttpServletResponse.class)) {
                responseMeta = toParamMeta(parameter, position);
                continue;
            }

            paramsMetas.add(toParamMeta(parameter, position));
        }

        return new MethodMeta(requestMeta, responseMeta, paramsMetas.toArray(new ParamMeta[paramsMetas.size()]));
    }

    private ParamMeta toParamMeta(Parameter parameter, int position) {
        return new ParamMeta(parameter.getName(), parameter.getType(), position);
    }
}
