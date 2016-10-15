package com.lance.test.core.optional;

import org.junit.Test;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by perdonare on 2016/6/16.
 */
public class OptionalTest {
    @Test
    public void testOptional() {
        String name1 = null;
        String name2 = "lance";
        Date date = null;
        Optional<String> nameOps = Optional.ofNullable(name1);

        System.out.println("is not null: " + nameOps.isPresent());
        System.out.println("name : " + nameOps.orElse("null value"));
        System.out.println(nameOps.map(e->"yes this is " + e).orElse("yes this is null"));
        System.out.println(nameOps.filter(value->value.length()>2).orElse("woca"));

        nameOps = Optional.ofNullable(name2);
        System.out.println("is not null: " + nameOps.isPresent());
        System.out.println("name : " + nameOps.orElse("null value"));
        System.out.println(nameOps.map(e->"yes this is " + e).orElse("yes this is null"));
        System.out.println(nameOps.filter(value->value.length()>8).orElse("woca"));

        Optional<Date> nameOps2 = Optional.ofNullable(date);
        System.out.println("is not null: " + nameOps2.isPresent());
        System.out.println("name : " + nameOps2.orElse(new Date()));
        System.out.println(nameOps2.map(e->"yes this is " + e).orElse("yes this is null"));
        System.out.println(nameOps2.filter(value->value.getTime()>100000).orElse(new Date()));
    }

    @Test
    public void testUtil() {
        String name = null;
        Objects.requireNonNull(name,"不能为空");
        System.out.println("aa");
    }
}
