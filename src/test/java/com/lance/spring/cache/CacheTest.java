package com.lance.spring.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by perdonare on 2016/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class CacheTest {
    @Resource
    private CacheDemo cacheDemo;

    @Test
    public void testCacheable() throws Exception {
        CacheModel cacheModel = new CacheModel();
        cacheModel.setName("lance");
        cacheModel.setAge(new Random().nextInt());
        cacheModel.setPassword("qqqq");

        cacheDemo.insertModel(cacheModel);
        cacheDemo.getModel("lance");
        cacheDemo.getModel("lance");
    }

    @Test
    public void testCacheConfig() throws Exception {

    }

    @Test
    public void testCachePut() throws Exception {
        CacheModel cacheModel = new CacheModel();
        cacheModel.setName("lance");
        cacheModel.setPassword("aaaa");
        cacheModel.setAge(new Random().nextInt());

        cacheDemo.insertModel(cacheModel);
        cacheModel.setPassword("bbbb");
        cacheDemo.updateModel(cacheModel);
        cacheDemo.getModel("lance");
    }

    @Test
    public void testCacheEvict() throws Exception {
        CacheModel cacheModel = new CacheModel();
        cacheModel.setName("lance");
        cacheModel.setPassword("aaaa");
        cacheModel.setAge(new Random().nextInt());

        cacheDemo.insertModel(cacheModel);
        cacheDemo.getModel("lance");
        cacheDemo.deleteModel("lance");
        cacheDemo.getModel("lance");
    }
}
