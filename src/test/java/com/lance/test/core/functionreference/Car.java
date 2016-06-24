package com.lance.test.core.functionreference;

/**
 * Created by perdonare on 2016/6/16.
 */
public class Car {
    public static Car create(final Supplier supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided  " + car.toString());
    }

    public void folllow(final Car another) {
        System.out.println("follow  " + another.toString());
    }

    public void repair() {
        System.out.println("repaired  " + this.toString());
    }

}
