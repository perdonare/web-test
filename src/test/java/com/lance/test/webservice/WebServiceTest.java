package com.lance.test.webservice;

import com.lance.test.webservice.impl.MathImpl;
import org.junit.Test;

import javax.xml.ws.Endpoint;

/**
 * Created by perdonare on 2015/9/23.
 */
public class WebServiceTest {
    @Test
    public void testWebService() throws InterruptedException {
        Endpoint.publish("http://localhost:8080/aa",new MathImpl());
        Thread.sleep(500000);
    }
}
