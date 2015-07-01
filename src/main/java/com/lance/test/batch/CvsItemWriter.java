/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      CvsItemReader.java
 * Create on:      2015/6/15 10:34
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/6/15 10:34               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.test.batch;


import com.lance.persistence.model.User;
import org.springframework.batch.item.ItemProcessor;

public class CvsItemWriter implements ItemProcessor<User,User>{
    @Override
    public User process(User user) throws Exception {
        user.setName(user.getName()+"aaaaa");
        return user;
    }
}
