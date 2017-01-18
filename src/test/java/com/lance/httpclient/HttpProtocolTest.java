package com.lance.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by perdonare on 2016/12/13.
 */
public class HttpProtocolTest {
    @Test
    public void testGet() throws IOException {
        HttpResponse content = Request.Get("http://localhost:5000/credit-trade-loan/vi/api/order/aaaaaa").connectTimeout(5).socketTimeout(5).execute().returnResponse();
        System.out.println(content);
    }

    public void testPut() throws IOException {
        String content = Request.Put("").connectTimeout(5).socketTimeout(5).body(null).execute().returnContent().asString();
    }

    public void testPost() throws IOException {
        String content = Request.Post("").connectTimeout(5).socketTimeout(5).body(null).execute().returnContent().asString();
        //Request.Post("").bodyForm(null)
    }

    public void testDelete() throws IOException {
        String content = Request.Delete("").connectTimeout(5).socketTimeout(5).body(new StringEntity("sdf")).execute().returnContent().asString();
    }
}
