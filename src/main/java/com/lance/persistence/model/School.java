/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      School.java
 * Create on:      2015/6/1 8:54
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/6/1 8:54               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.persistence.model;


public class School {

    private int id;

    private String schoolName;

    private String schoolNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("School{");
        sb.append("id=").append(id);
        sb.append(", schoolName='").append(schoolName).append('\'');
        sb.append(", schoolNo='").append(schoolNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
