package com.lance.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by perdonare on 2015/6/16.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("login")
    public String userLogin(){
        return "login/login";
    }

    @RequestMapping("login/login")
    public String userLoginCheck(String username,String password,HttpSession session){
        if(username.equals("user1")){
            session.setAttribute("username","user1");
            return "login/success";
        } else if (username.equals("user2")){
            session.setAttribute("username","user2");
            return "login/success";
        } else if (username.equals("user3")){
            session.setAttribute("username","user3");
            return "login/success";
        }else if (username.equals("user4")){
            session.setAttribute("username","user4");
            return "login/success";
        }else if (username.equals("user5")){
            session.setAttribute("username","user5");
            return "login/success";
        }else if (username.equals("user6")){
            session.setAttribute("username","user6");
            return "login/success";
        }else if (username.equals("user7")){
            session.setAttribute("username","user7");
            return "login/success";
        } else {
            return "login/fail";
        }
    }
}
