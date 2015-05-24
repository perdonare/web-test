package com.lance.controller;

import com.lance.common.EasyUIModel;
import com.lance.persistence.mapper.UserMapper;
import com.lance.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    public EasyUIModel<User> testEasyUIJsonData(){
        List<User> list = new ArrayList<User>();
        User user = userMapper.selectByPrimaryKey((long) 5);
        User user2 = userMapper.selectByPrimaryKey((long) 4);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user2);
        EasyUIModel result = new EasyUIModel(5,list);
        return result;
    }
}
