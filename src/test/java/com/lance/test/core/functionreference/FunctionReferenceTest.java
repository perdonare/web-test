package com.lance.test.core.functionreference;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by perdonare on 2016/6/16.
 */
public class FunctionReferenceTest {

    @Test
    public void testReference() {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        // 类 静态方法引用
        cars.forEach(Car::collide);
        //类 方法引用
        cars.forEach(Car::repair);
        //实例方法引用
        final Car another = Car.create(Car::new);
        cars.forEach(another::folllow);
    }


}
