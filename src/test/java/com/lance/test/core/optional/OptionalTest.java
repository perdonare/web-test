package com.lance.test.core.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by perdonare on 2016/6/16.
 */
public class OptionalTest {
    @Test
    public void testOptional() {
        String name = "lance";
        //String name = null;
        Optional<String> nameOps = Optional.ofNullable(name);

        System.out.println("is not null: " + nameOps.isPresent());

        System.out.println("name : " + nameOps.orElse("null value"));

        System.out.println(nameOps.map(e->"yes this is " + e).orElse("yes this is null"));

    }
}
