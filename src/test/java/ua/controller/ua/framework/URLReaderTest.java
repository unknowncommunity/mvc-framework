package ua.controller.ua.framework;

import org.junit.Before;
import org.junit.Test;
import ua.controller.SimpleController;
import ua.controller.ua.framework.model.meta.URLMeta;

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
//        urlMetas.stream().forEach(System.out::println);

    }
}