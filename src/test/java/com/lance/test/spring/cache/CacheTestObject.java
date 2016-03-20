package com.lance.test.spring.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/12/27.
 */
@Service
public class CacheTestObject {
    public static  long aa =100;
    @Cacheable("time")
    public long getMoney() {
        return System.currentTimeMillis();
    }

    @CacheEvict("time")
    //@Cacheable("time")
    public long getAnotherMoney() {
        return System.currentTimeMillis();
    }

    //@CachePut("time")
    @Cacheable("time")
    public long getOne() {
        System.out.println("testOne");
        return System.currentTimeMillis();
    }

    @Cacheable("time")
    public long getAll() {
        return System.currentTimeMillis();
    }
}
