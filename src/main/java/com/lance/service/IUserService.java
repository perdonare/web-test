/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      IUserService.java
 * Create on:      2015/8/3 0003 13:40
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/8/3 0003 13:40               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.service;

import com.lance.controller.bo.UserBO;

import java.util.List;

/**
 * <b>DESCRIPTION:</b><br/>
 * <b>Create on:</b>2015/8/3 0003<br/>
 *
 * @author 袁其亮
 */
public interface IUserService {
    List<UserBO> getUsers();
}
