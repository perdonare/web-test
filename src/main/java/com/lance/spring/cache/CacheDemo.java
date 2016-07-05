package com.lance.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by perdonare on 2016/7/5.
 */
@Service
@CacheConfig(cacheNames = "personal")
public class CacheDemo {
    private static  Map<String,CacheModel> map = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(CacheDemo.class);

    @Cacheable
    public CacheModel getModel(String name) {
        CacheModel cacheModel = map.get(name);
        logger.info("=====get model:{}",cacheModel);
        return cacheModel;
    }

    //@CacheEvict
    public void deleteModel(String name) {
        logger.info("===== delete model:{}",name);
        //map.remove(name);
    }

    @CachePut(key = "#cacheModel.name")
    public void updateModel(CacheModel cacheModel) {
        logger.info("===== update model:{}",cacheModel);
        map.put(cacheModel.getName(),cacheModel);
    }

    public void insertModel(CacheModel cacheModel) {
        logger.info("===== insert model:{}",cacheModel);
        map.put(cacheModel.getName(),cacheModel);
    }




}
