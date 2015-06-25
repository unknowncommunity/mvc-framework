package ua.uc.framework.model.meta;

import ua.uc.framework.model.RequestMethod;
import ua.uc.framework.processors.request.RequestProcessor;

import java.util.Arrays;

/**
 * @author Tradunsky V.V.
 */
public class URLMeta {
    private final String uriPath;
    private final ParamMeta[] params;
    private final Object result;
    private final RequestMethod requestMethod;

    public URLMeta(String uriPath, ParamMeta[] params, Object result, RequestMethod requestMethod) {
        this.uriPath = uriPath;
        this.params = params;
        this.result = result;
        this.requestMethod = requestMethod;
    }

    public String getUriPath() {
        return uriPath;
    }

    public Object[] getParams() {
        return params.clone();
    }

    public Object getResult() {
        return result;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URLMeta urlMeta = (URLMeta) o;

        if (uriPath != null ? !uriPath.equals(urlMeta.uriPath) : urlMeta.uriPath != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(params, urlMeta.params)) return false;
        if (result != null ? !result.equals(urlMeta.result) : urlMeta.result != null) return false;
        return requestMethod == urlMeta.requestMethod;

    }

    @Override
    public int hashCode() {
        int result1 = uriPath != null ? uriPath.hashCode() : 0;
        result1 = 31 * result1 + (params != null ? Arrays.hashCode(params) : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (requestMethod != null ? requestMethod.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "URLMeta{" +
                "uriPath='" + uriPath + '\'' +
                ", params=" + Arrays.toString(params) +
                ", result=" + result +
                ", requestMethod=" + requestMethod +
                '}';
    }
}
