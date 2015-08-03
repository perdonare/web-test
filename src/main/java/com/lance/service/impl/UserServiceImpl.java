/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      UserServiceImpl.java
 * Create on:      2015/8/3 0003 13:42
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/8/3 0003 13:42               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.service.impl;

import com.google.common.collect.Lists;
import com.lance.controller.bo.UserBO;
import com.lance.persistence.model.AccountPO;
import com.lance.persistence.service.IAccountService;
import com.lance.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b>DESCRIPTION:</b><br/>
 * <b>Create on:</b>2015/8/3 0003<br/>
 *
 * @author 袁其亮
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IAccountService userService;
    @Override
    public List<UserBO> getUsers() {
        List<AccountPO> accountPOs = userService.getUsers();
        List<UserBO> userBOs = Lists.newArrayList();
        if (accountPOs!=null && !accountPOs.isEmpty()) {
            for (AccountPO accountPO : accountPOs) {
                userBOs.add(userBOConvert(accountPO));
            }
        }

        return userBOs;
    }

    private UserBO userBOConvert(AccountPO accountPO) {
        UserBO userBO = new UserBO();
        userBO.setUsername(accountPO.getLoginAccount());
        userBO.setPassword(accountPO.getLoginPassword());
        userBO.setCreateTime(accountPO.getCreateTime());
        userBO.setEmail(accountPO.getContactEmail());
        return userBO;
    }
}
