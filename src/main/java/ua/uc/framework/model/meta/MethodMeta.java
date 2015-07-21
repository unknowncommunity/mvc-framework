package ua.uc.framework.model.meta;

import java.util.Arrays;

/**
 * Created by kostya on 21.07.15.
 */
public class MethodMeta {
    private final ParamMeta requestMeta;
    private final ParamMeta responseMeta;
    private final ParamMeta[] restParams;

    public MethodMeta(ParamMeta requestMeta, ParamMeta responseMeta, ParamMeta[] restParams) {
        this.requestMeta = requestMeta;
        this.responseMeta = responseMeta;
        this.restParams = restParams;
    }

    public ParamMeta getRequestMeta() {
        return requestMeta;
    }

    public ParamMeta getResponseMeta() {
        return responseMeta;
    }

    public ParamMeta[] getRestParams() {
        return restParams;
    }

    public int getAttrsSize() {
        int size = 0;
        if (restParams != null) {
            size += restParams.length;
        }
        if (requestMeta != null) {
            size += 1;
        }
        if (responseMeta != null) {
            size += 1;
        }
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodMeta that = (MethodMeta) o;

        if (requestMeta != null ? !requestMeta.equals(that.requestMeta) : that.requestMeta != null) return false;
        if (responseMeta != null ? !responseMeta.equals(that.responseMeta) : that.responseMeta != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(restParams, that.restParams);

    }

    @Override
    public int hashCode() {
        int result = requestMeta != null ? requestMeta.hashCode() : 0;
        result = 31 * result + (responseMeta != null ? responseMeta.hashCode() : 0);
        result = 31 * result + (restParams != null ? Arrays.hashCode(restParams) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MethodMeta{" +
                "requestMeta=" + requestMeta +
                ", responseMeta=" + responseMeta +
                ", restParams=" + Arrays.toString(restParams) +
                '}';
    }
}
