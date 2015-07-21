package ua.uc.framework.context;

import ua.uc.framework.holders.meta.URLMetaHolder;
import ua.uc.framework.holders.processors.ProcessorsHolder;
import ua.uc.framework.initialization.ClassProcessor;
import ua.uc.framework.model.RequestMethod;
import ua.uc.framework.model.meta.URLMeta;
import ua.uc.framework.processors.request.RequestProcessor;

import java.util.List;

/**
 * Created by kostya on 25.06.15.
 */
public class BasicContext {
    private URLMetaHolder urlMetaHolder = URLMetaHolder.get();
    private ProcessorsHolder processorsHolder = ProcessorsHolder.get();

    private ClassProcessor classProcessor;

    public BasicContext() {
        classProcessor = new ClassProcessor();
    }

    public void init(List<String> controllers) {
        for (String controllerClass : controllers) {
            Class controller = null;
            try {
                controller = Class.forName(controllerClass);
            } catch (Exception e) {
                continue;
            }
            classProcessor.process(controller);
        }
    }

    public URLMeta getUrlMeta(String requestUri, RequestMethod requestMethod) {
        return urlMetaHolder.get(requestUri, requestMethod);
    }

    public RequestProcessor getRequestProcessor(URLMeta urlMeta) {
        return processorsHolder.get(urlMeta);
    }

    public RequestProcessor getRequestProcessor(String requestUri, RequestMethod requestMethod) {
        URLMeta urlMeta = getUrlMeta(requestUri, requestMethod);
        return getRequestProcessor(urlMeta);
    }
}
