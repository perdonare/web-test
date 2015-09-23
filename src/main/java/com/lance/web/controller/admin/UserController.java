package com.lance.web.controller.admin;


import com.fasterxml.jackson.annotation.JsonView;
import com.lance.common.model.EasyModel;
import com.lance.common.model.Response;
import com.lance.model.AccountBO;
import com.lance.persistence.model.User;
import com.lance.service.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by perdonare on 2015/8/3.
 */

@Controller
@RequestMapping("/admin")
public class UserController {

    @Resource
    private IAccountService accountServiceImp;
    @RequestMapping("/manage")
    public String userManage(){
        return "admin/manage";
    }

    @RequestMapping(value="/account", method = RequestMethod.POST)
    @ResponseBody
    public Response<EasyModel<AccountBO>> manageAccount(int page,int rows){
        EasyModel<AccountBO> easyModel = new EasyModel<>();
        List<AccountBO>  accountBOs = accountServiceImp.getAccounts(page,rows);
        easyModel.setRows(accountBOs);
        easyModel.setTotal(accountBOs.size());
        Response<EasyModel<AccountBO>> response = new Response<>(easyModel);
        return response;
    }

    @RequestMapping(value="/test", method = RequestMethod.POST)
    @JsonView(User.class)
    @ResponseBody
    public User manageTest(){
        User user = new User();
        user.setName("lance");
        user.setPassword("aaa");
        return user;
    }



}
