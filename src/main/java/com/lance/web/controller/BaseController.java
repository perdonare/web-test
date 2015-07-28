package com.lance.web.controller;

import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by perdonare on 2015/7/26.
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @RequestMapping("")
    public String base() {
        return "redirect:/index.jsp";
    }

    @RequestMapping("index")
    public String index(){
        return "redirect:/index.jsp";
    }

    @RequestMapping("loginForm")
    public String login(){
        return "login/loginForm";
    }
    @RequestMapping("login")
    public String success(){
        return "home";
    }


}
