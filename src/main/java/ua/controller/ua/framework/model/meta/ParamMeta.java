package ua.controller.ua.framework.model.meta;

import java.lang.reflect.Parameter;

/**
 * @author Tradunsky V.V.
 */
public class ParamMeta {
    private String paramName;
    private Class paramType;

    public ParamMeta(){}

    public ParamMeta(String paramName, Class paramType) {
        this.paramName = paramName;
        this.paramType = paramType;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Class getParamType() {
        return paramType;
    }

    public void setParamType(Class paramType) {
        this.paramType = paramType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParamMeta paramMeta = (ParamMeta) o;

        if (paramName != null ? !paramName.equals(paramMeta.paramName) : paramMeta.paramName != null) return false;
        if (paramType != null ? !paramType.equals(paramMeta.paramType) : paramMeta.paramType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paramName != null ? paramName.hashCode() : 0;
        result = 31 * result + (paramType != null ? paramType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParamMeta{" +
                "paramName='" + paramName + '\'' +
                ", paramType=" + paramType +
                '}';
    }
}
