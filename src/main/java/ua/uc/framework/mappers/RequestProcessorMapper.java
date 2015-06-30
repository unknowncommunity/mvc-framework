package ua.uc.framework.mappers;

import ua.uc.framework.processors.request.RequestProcessor;

import java.lang.reflect.Method;

/**
 * Created by kostya on 25.06.15.
 */
public class RequestProcessorMapper implements Mapper<Method, RequestProcessor> {
    private final Object controller;
    private ParamMetaMapper paramMetaMapper;

    public RequestProcessorMapper(Object controller) {
        paramMetaMapper = new ParamMetaMapper();
        this.controller = controller;
    }

    @Override
    public RequestProcessor map(Method method) {
        return new RequestProcessor(controller, method, paramMetaMapper.map(method));
    }
}
