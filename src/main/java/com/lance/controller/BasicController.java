package com.lance.controller;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by perdonare on 2015/7/21.
 */
@Controller
@RequestMapping("/")
public class BasicController {
    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("checkLogin")
    public String checkLogin(){
        return "index";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
