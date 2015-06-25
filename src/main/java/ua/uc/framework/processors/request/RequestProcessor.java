package ua.uc.framework.processors.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by kostya on 25.06.15.
 */
public class RequestProcessor {
    private Object controller;
    private Method method;

    public RequestProcessor() {
    }

    public RequestProcessor(Object controller, Method method) {
        this.controller = controller;
        this.method = method;
    }

    public HttpServletResponse process(HttpServletRequest request, HttpServletResponse response) {
        try {
            return (HttpServletResponse) method.invoke(controller, request, response);
        } catch (Exception ex) {
            int a = 1 + 1;
        }
        return null;
    }

}
