package com.lance.test.spring;

import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by perdonare on 2015/12/20.
 */
@Service
public class TestValidate {
    @NotNull(message = "empty")
    private String name;

    @Size(min = 1,max = 50,message = "too old")
    private int age;
}
