package com.lance.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by perdonare on 2015/6/27.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/loginForm")
    public String loginDefault(){
        return "login/login";
    }

    @RequestMapping("")
    public String validate(){
        return "redirect:/index.jsp";
    }

}
