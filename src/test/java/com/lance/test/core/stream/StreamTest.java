package com.lance.test.core.stream;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.gen5.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by perdonare on 2016/6/16.
 */
@Slf4j
public class StreamTest {

    @Test
    public void testStreams() throws Exception {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("lance",27));
        personList.add(new Person("liang",25));
        personList.forEach(person -> person.setAge(person.getAge()+100));
        System.out.println(personList);
    }

    @Test
    public void testList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("lance", 27));
        personList.add(new Person("liang", 25));

        List<People> peopleList = new ArrayList<>();
        personList.forEach(item -> {
            peopleList.add(new People(item.name, item.age));
        });

        System.out.println(personList);


    }

    @Test
    public void testFunctional() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("lance", 27));
        personList.add(new Person("liang", 25));

        personList.forEach(Person::getAge);
        personList.forEach(System.out::println);
        personList.forEach(System.out::println);
        //personList.forEach(log::info);
    }

    @Data
    class Person{
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;
    }

    @Data
    class People{
        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;
    }
}
