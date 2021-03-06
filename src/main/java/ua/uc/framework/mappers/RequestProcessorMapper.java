package ua.uc.framework.mappers;

import ua.uc.framework.processors.request.RequestProcessor;

import java.lang.reflect.Method;

/**
 * Created by kostya on 25.06.15.
 */
public class RequestProcessorMapper implements Mapper<Method, RequestProcessor> {
    private final Object controller;

    public RequestProcessorMapper(Object controller) {
        this.controller = controller;
    }

    @Override
    public RequestProcessor map(Method method) {
        return new RequestProcessor(controller, method);
    }
}
