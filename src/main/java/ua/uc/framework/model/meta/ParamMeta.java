package ua.uc.framework.model.meta;

/**
 * @author Tradunsky V.V.
 */
public class ParamMeta {
    private final String paramName;
    private final Class paramType;
    private final int position;

    public ParamMeta(String paramName, Class paramType, int position) {
        this.paramName = paramName;
        this.paramType = paramType;
        this.position = position;
    }

    public String getParamName() {
        return paramName;
    }

    public Class getParamType() {
        return paramType;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParamMeta paramMeta = (ParamMeta) o;

        if (position != paramMeta.position) return false;
        if (paramName != null ? !paramName.equals(paramMeta.paramName) : paramMeta.paramName != null) return false;
        return !(paramType != null ? !paramType.equals(paramMeta.paramType) : paramMeta.paramType != null);

    }

    @Override
    public int hashCode() {
        int result = paramName != null ? paramName.hashCode() : 0;
        result = 31 * result + (paramType != null ? paramType.hashCode() : 0);
        result = 31 * result + position;
        return result;
    }

    @Override
    public String toString() {
        return "ParamMeta{" +
                "paramName='" + paramName + '\'' +
                ", paramType=" + paramType +
                ", position=" + position +
                '}';
    }
}
