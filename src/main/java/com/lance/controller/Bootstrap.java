/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      Bootstrap.java
 * Create on:      2015/7/17 0017 15:30
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/7/17 0017 15:30               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.controller;

import com.lance.controller.bo.ResponseModel;
import com.lance.controller.bo.UserBO;
import com.lance.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test/bootstrap")
public class Bootstrap {
    @Autowired
    private IUserService userService;
    @RequestMapping("/home")
    public String start(){
        return "bootstrap/start";
    }

    @RequestMapping("/dropDown")
    public String dropDown(){
        return "bootstrap/dropDown";
    }

    @RequestMapping("/test")
    public String test(){
        return "bootstrap/test";
    }

    @RequestMapping("/bsgrid")
    public String getData(){
        return "bootstrap/bsgrid";
    }


    @RequestMapping("/data/json")
    @ResponseBody
    public ResponseModel<List<UserBO>> userManage(){
        List<UserBO> userBOs = userService.getUsers();
        ResponseModel<List<UserBO>> responseModel = new ResponseModel(userBOs);
        return responseModel;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
