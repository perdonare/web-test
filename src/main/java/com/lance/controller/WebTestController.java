package com.lance.controller;

import com.lance.persistence.mapper.UserMapper;
import com.lance.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by perdonare on 2015/5/3.
 */
@Controller
@RequestMapping("/test")
public class WebTestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public String test(){
        User u = new User();
        u.setName("aaa");
        u.setPassword("bbb");
        userMapper.insert(u);
        User user = userMapper.selectByPrimaryKey((long) 5);
        System.out.println(user);
        return "index";
    }
}
