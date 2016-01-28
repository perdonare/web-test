package com.lance.test.spring;

import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/20.
 */
@Service
public class FitImpl implements Fit {
    @Override
    public void fun() {
        System.out.println("fit impl.");
    }
}
