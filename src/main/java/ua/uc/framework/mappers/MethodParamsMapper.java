package ua.uc.framework.mappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by kostya on 30.06.15.
 */
public class MethodParamsMapper {

    public Object[] map(HttpServletRequest request, HttpServletResponse response) {
        return new Object[] {request, response};
    }
}
