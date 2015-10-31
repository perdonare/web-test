package com.lance.test.webservice;

import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by perdonare on 2015/9/23.
 */
public class WebClientTest {
    @Test
    public void testWebService() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/aa?wsdl");
        QName qName = new QName("http://impl.webservice.test.lance.com/","MathImplService");
        Service service = Service.create(url,qName);
        IMath math = service.getPort(IMath.class);
        System.out.println(math.add(1,2));
    }
}
