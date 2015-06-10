/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      Clazz.java
 * Create on:      2015/6/1 8:52
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/6/1 8:52               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.persistence.model;


public class Clazz {
    private int id;

    private String classname;

    private String classNo;

    private int classMaxUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public int getClassMaxUser() {
        return classMaxUser;
    }

    public void setClassMaxUser(int classMaxUser) {
        this.classMaxUser = classMaxUser;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Clazz{");
        sb.append("id=").append(id);
        sb.append(", classname='").append(classname).append('\'');
        sb.append(", classNo='").append(classNo).append('\'');
        sb.append(", classMaxUser=").append(classMaxUser);
        sb.append('}');
        return sb.toString();
    }
}
