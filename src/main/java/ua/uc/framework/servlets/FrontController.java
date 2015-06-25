package ua.uc.framework.servlets;

import ua.uc.framework.context.BasicContext;
import ua.uc.framework.model.RequestMethod;
import ua.uc.framework.processors.request.RequestProcessor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by kostya on 25.06.15.
 */
public class FrontController extends HttpServlet {
    protected BasicContext context;

    public FrontController() {
        context = new BasicContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = excludeContextPathFromUri(req.getRequestURI(), req.getContextPath());
        RequestMethod requestMethod = RequestMethod.valueOf(req.getMethod());
        RequestProcessor requestProcessor = context.getRequestProcessor(uri, requestMethod);
        requestProcessor.process(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    private String excludeContextPathFromUri(String uri, String contextPath) {
        return uri.substring(contextPath.length() + 1);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        String controllers = config.getInitParameter("controllers");
        String servletName = config.getServletName();

        context.init(Arrays.asList(controllers.split(",")));
    }
}
