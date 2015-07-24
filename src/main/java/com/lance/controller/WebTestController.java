package com.lance.controller;

import com.google.common.collect.Lists;
import com.lance.persistence.mapper.UserMapper;
import com.lance.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.jaasapi.JaasApiIntegrationFilter;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by perdonare on 2015/5/3.
 */
@Controller
@RequestMapping("/test")
public class WebTestController {
    //@RequestParam, @RequestHeader, @PathVariable

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/form")
    public String testPOJO(){
        return "test/Form";
    }

    @RequestMapping("/user")
    public String test(){
        User u = new User();
        u.setName("aaa");

        u.setPassword("bbb");
        userMapper.insert(u);
        User user = userMapper.selectByPrimaryKey(5L);
        System.out.println(user);
        return "index";
    }

    //测试@PathVariable
    @RequestMapping("{method}")
    public String testPathVariable(@PathVariable String method){
        return "test/"+"PathVariable"+method;
    }

    @RequestMapping("/pojo")
    public ModelAndView testPOJO(User user){
        ModelAndView modelAndView = new ModelAndView("test/User");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/forward")
    public String testForward(){
        return "forward:/test/Add";
    }

    @RequestMapping("/redirect")
    public String testRedirect(){
        return "redirect:/test/Add";
    }

    @RequestMapping("/requestParam")
    public ModelAndView testRequestParam(@RequestParam(value="_id") String id){
        ModelAndView modelAndView = new ModelAndView("test/RequestParam");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<User> testJson(){
        List users = Lists.newArrayList();
        User user = new User();
        user.setId(3);
        user.setName("lance");
        user.setPassword("lance");
        users.add(user);
        users.add(user);
        //FilterSecurityInterceptor
       
        return users;
    }
    @RequestMapping("/authentication")
    public String authenticate(){
        return "/test/authentication";
    }
}
