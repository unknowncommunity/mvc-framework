package ua.uc.framework.processors.request;

import ua.uc.framework.mappers.MethodParamsMapper;
import ua.uc.framework.model.meta.MethodMeta;
import ua.uc.framework.model.meta.ParamMeta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by kostya on 25.06.15.
 */
public class RequestProcessor {
    private Object controller;
    private Method method;
    private MethodMeta methodMeta;
    private MethodParamsMapper methodParamsMapper;

    public RequestProcessor(Object controller, Method method, MethodMeta methodMeta) {
        this.controller = controller;
        this.method = method;
        this.methodParamsMapper = new MethodParamsMapper(methodMeta);
    }

    public HttpServletResponse process(HttpServletRequest request, HttpServletResponse response) {
        try {
            Object[] params = methodParamsMapper.map(request, response);
            return (HttpServletResponse) method.invoke(controller, params);
        } catch (Exception ex) {

        }
        return null;
    }
}
