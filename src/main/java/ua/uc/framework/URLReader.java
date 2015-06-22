package ua.uc.framework;

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
    public List<URLMeta> processClassURL(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods)
                .filter(m -> Modifier.isPublic(m.getModifiers()))
                .map(URLReader::mapMethodToURLMeta)
                .collect(toList());
    }

    private static URLMeta mapMethodToURLMeta(Method method){
        return new URLMeta(method.getName(), mapToParamMeta(method), method.getReturnType());
    }

    private static ParamMeta[] mapToParamMeta(Method method) {
        Parameter[] parameters = method.getParameters();
        Class[] parametersTypes = method.getParameterTypes();
        ParamMeta[] paramsMetas = new ParamMeta[parametersTypes.length];
        for (int i = 0; i < parameters.length; i++) {
            paramsMetas[i] = new ParamMeta(parameters[i].getName(), parameters[i].getType());
        }
        return paramsMetas;
    }
}
