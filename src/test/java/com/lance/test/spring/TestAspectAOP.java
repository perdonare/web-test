package com.lance.test.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by perdonare on 2015/12/20.
 */
@Service
public class TestAspectAOP {
    public void beforeDate() {
        System.out.println("before"+new Date());
    }

    public void afterReturnDate() {
        System.out.println("after return"+new Date());
    }

    public void afterDate() {
        System.out.println("after"+new Date());
    }

    public void afterThrowingDate() {
        System.out.println("after throwing" + new Date());
    }

    public void aroundDate(ProceedingJoinPoint point) throws Throwable {
        long before = System.currentTimeMillis();
        point.proceed();
        System.out.println("time(second):"+(System.currentTimeMillis()-before)/1000);
    }

    public Object aroundParamDate(ProceedingJoinPoint point,String name,int age) throws Throwable {
        System.out.println("begin");
        Object myname = point.proceed(new Object[]{name,age});
        System.out.println("end"+(String)myname);
        return myname;
    }

}
