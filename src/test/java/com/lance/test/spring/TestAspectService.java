package com.lance.test.spring;

import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/20.
 */
@Service
public class TestAspectService {
    public void sayHi() throws Exception {
        System.out.println("hello world");
        Thread.sleep(5000);
        //throw  new Exception();
    }

    public String sayHiParam (String name,int age) {
        return name;
    }

}
