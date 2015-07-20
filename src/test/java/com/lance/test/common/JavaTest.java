/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      JavaTest.java
 * Create on:      2015/7/17 0017 18:10
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/7/17 0017 18:10               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.test.common;

import java.util.Properties;

public class JavaTest {
    // 创建session
    // 创建属性列表
    private Properties prop;
    // 默认的邮件服务器域名
    private String mailServerHost ;
    // 邮件发送服务器端口号
    private  String mailServerPort = "25";
    // 登陆邮件发送服务器的用户名
    private static String mailSenderName;
    // 登陆邮件发送服务器的密码
    private String mailSenderPassword;
    // 发送邮件的标识(默认发送)
    private boolean sendFlag = true;

    public JavaTest() {
        MailServerConfig();
    }

    private void MailServerConfig() {
        try {
            // 获取邮件发送的基础信息
            getMailInfo();
            // 获取发送邮件服务器属性集
            getProperties();
            // 创建邮件发送服务器的session对象
        } catch (Exception ex) {
            sendFlag = false;// 设置邮件发送标识为不发送
        }
    }

    /**
     * <b>DESCRIPTION:</b>通过系统配置表获取邮件发送的基础信息<br/>
     * <b>Create on:</b>2015-7-17 上午11:32:54 <br/>
     * <b>author:</b>ZHOUGUI
     */
    private void getMailInfo() {
        // 待开发
    }

    /**
     * <b>DESCRIPTION:</b>配置发送邮件服务器属性集<br/>
     * <b>Create on:</b>2015-7-17 上午10:12:29 <br/>
     * <b>author:</b>ZHOUGUI
     *
     * @return
     */
    private void getProperties() {
        prop = new Properties();
        prop.setProperty("mail.host", mailServerHost);
        prop.setProperty("mail.smtp.port", mailServerPort);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
    }
}
