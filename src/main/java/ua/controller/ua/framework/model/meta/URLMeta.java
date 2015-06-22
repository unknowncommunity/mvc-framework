package ua.controller.ua.framework.model.meta;

import java.util.Arrays;

/**
 * @author Tradunsky V.V.
 */
public class URLMeta {
    private String uriPath;
    private ParamMeta[] params;
    private Object result;

    public URLMeta(){}

    public URLMeta(String uriPath, ParamMeta[] params, Object result) {
        this.uriPath = uriPath;
        this.params = params;
        this.result = result;
    }

    public String getUriPath() {
        return uriPath;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(ParamMeta[] params) {
        this.params = params;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URLMeta urlMeta = (URLMeta) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(params, urlMeta.params)) return false;
        if (result != null ? !result.equals(urlMeta.result) : urlMeta.result != null) return false;
        if (uriPath != null ? !uriPath.equals(urlMeta.uriPath) : urlMeta.uriPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = uriPath != null ? uriPath.hashCode() : 0;
        result1 = 31 * result1 + (params != null ? Arrays.hashCode(params) : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "URLMeta{" +
                "uriPath='" + uriPath + '\'' +
                ", params=" + Arrays.toString(params) +
                ", result=" + result +
                '}';
    }
}
