package ua.uc.framework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.uc.controller.SimpleController;
import ua.uc.framework.model.meta.URLMeta;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class URLReaderTest {

    URLReader urlReader;

    @Before
    public void init(){
        urlReader = new URLReader();
    }

    @Test
    public void testProcessClassURL() throws Exception {
        List<URLMeta> urlMetas = urlReader.processClassURL(SimpleController.class);
        urlMetas.stream().forEach(System.out::println);
        long publicMethodsCount = Arrays.stream(SimpleController.class.getDeclaredMethods())
                .filter(m-> Modifier.isPublic(m.getModifiers()))
                .count();
        assertEquals("Should return URLMeta for all public methods of controller", publicMethodsCount, urlMetas.size());
    }
}