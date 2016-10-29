package com.lance.reactive;

import rx.Observable;

/**
 * Created by perdonare on 2016/10/27.
 */
public class RxJavaDemo {
    public static void hello(String... names) {
        Observable.from(names).subscribe(e->{
            System.out.println(e);
        });
    }

    public static void helloFromExists(String... names) {
        Observable.just(names).subscribe(e->{
            System.out.println(e);
        });
    }

    public static void helloCreate(String names) {
        Observable.create(a-> {
            if (!a.isUnsubscribed()) {
                System.out.println(names);
            }
            a.unsubscribe();
        });
    }

    public static void helloAsyCreate(String names) {
        Observable.create(a->{
            new Thread(() -> {
                System.out.println(names);
            }).start();
        });
    }

    public static void helloMap(String... name) {
        Observable.from(name).map(e-> e+"aaa").take(2).subscribe(e->{
            System.out.println(e);
        });
    }

    public static void helloFlatMap(String... name) {
        Observable.from(name).map(e->e+"aaa").take(2).flatMap(a-> Observable.from(a.split(""))
        ).subscribe(e->{
            System.out.println(e);
        });
    }
}
