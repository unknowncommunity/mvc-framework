package ua.uc.framework.initialization.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by kostya on 25.06.15.
 */
public class ClassUtil {

    public static Collection<Method> getPublicMethods(Class clazz) {
        return Arrays.asList(clazz.getMethods()).stream().filter(m -> Modifier.isPublic(m.getModifiers())).collect(Collectors.toList());
    }
}
