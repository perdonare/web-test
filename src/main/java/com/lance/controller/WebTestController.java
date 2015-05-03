package com.lance.controller;

import com.lance.persistence.mapper.UserMapper;
import com.lance.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by perdonare on 2015/5/3.
 */
@Controller
@RequestMapping("/test")
public class WebTestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    @ResponseBody
    public String testUser(){
        User u = new User();
        u.setName("aaa");
        u.setPassword("bbb");
        userMapper.insert(u);
        User user = userMapper.selectByPrimaryKey((long) 5);
        return "index";
    }

    @RequestMapping("/easyui")
    public String testEasyUI(){
        return "test/easyui-helloworld";
    }

    @RequestMapping("/easyui/json")
    public String testEasyUIJson(){
        User user = userMapper.selectByPrimaryKey((long) 5);
        return "test/easyui-josn";
    }

    @RequestMapping(value = "/easyui/json/data",method = RequestMethod.POST)
    @ResponseBody
    public User testEasyUIJsonData(){
        User user = userMapper.selectByPrimaryKey((long) 5);
        return user;
    }
}
