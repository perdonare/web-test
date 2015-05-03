package com.lance.test;

import com.lance.persistence.model.User;
import com.lance.persistence.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by perdonare on 2015/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-config.xml"})
public class MybatisTest {


    private IUserService userService;

    @Test
    public void testPersistence(){
        User user = new User();
        user.setName("lanceccc");
        user.setPassword("1234");
        userService.addUser(user);
        User u = userService.getUser((long) 3);
        System.out.println(u.getName());
    }
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
