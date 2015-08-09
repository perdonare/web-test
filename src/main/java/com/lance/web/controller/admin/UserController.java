package com.lance.web.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by perdonare on 2015/8/3.
 */
@RequestMapping("/admin")
public class UserController {
    @RequestMapping("/manage")
    public String userManage(){
        return "admin/manage";
    }
}
