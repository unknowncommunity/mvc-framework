package ua.uc.framework.mappers;

import ua.uc.framework.model.meta.MethodMeta;
import ua.uc.framework.model.meta.ParamMeta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kostya on 30.06.15.
 */
public class MethodParamsMapper {
    private MethodMeta methodMeta;
    private int attrsSize; //helper field, prevent calculation of attrsSize on every map call

    public MethodParamsMapper(MethodMeta methodMeta) {
        this.methodMeta = methodMeta;
        attrsSize = methodMeta.getAttrsSize();
    }

    public Object[] map(HttpServletRequest request, HttpServletResponse response) {
        Object[] params = new Object[attrsSize];

        mapRequest(params, request);
        mapResponse(params, response);

        if (methodMeta.getRestParams() != null) {
            for (ParamMeta paramMeta : methodMeta.getRestParams()) {
                mapAttr(params, paramMeta);
            }
        }

        return params;
    }

    private void mapRequest(Object[] params, HttpServletRequest request) {
        if (methodMeta.getRequestMeta() != null) {
            params[methodMeta.getRequestMeta().getPosition()] = request;
        }
    }

    private void mapResponse(Object[] params, HttpServletResponse response) {
        if (methodMeta.getResponseMeta() != null) {
            params[methodMeta.getResponseMeta().getPosition()] = response;
        }
    }

    private void mapAttr(Object[] params, ParamMeta paramMeta) {
        params[paramMeta.getPosition()] = null;
    }
}
