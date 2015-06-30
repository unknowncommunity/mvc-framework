package ua.uc.framework.processors.request;

import ua.uc.framework.mappers.MethodParamsMapper;
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
    private ParamMeta[] paramMeta;
    private MethodParamsMapper methodParamsMapper;

    public RequestProcessor() {
        methodParamsMapper = new MethodParamsMapper();
    }

    public RequestProcessor(Object controller, Method method, ParamMeta[] paramMeta) {
        this();
        this.controller = controller;
        this.method = method;
        this.paramMeta = paramMeta;
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
