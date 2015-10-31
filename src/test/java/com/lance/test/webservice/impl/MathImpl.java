package com.lance.test.webservice.impl;

import com.lance.test.webservice.IMath;

import javax.jws.WebService;

/**
 * Created by perdonare on 2015/9/23.
 */
@WebService(endpointInterface = "com.lance.test.webservice.IMath")
public class MathImpl implements IMath {
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
