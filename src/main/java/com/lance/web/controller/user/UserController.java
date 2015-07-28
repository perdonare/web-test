package com.lance.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by perdonare on 2015/7/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("")
    public String base() {
        return "user/userCenter";
    }
}
