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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test/bootstrap")
public class Bootstrap {
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
}
