package com.lance.persistence.model;

import lombok.Data;

import java.util.Date;
@Data
public class UserLeavePO {
    private int id;

    private String name;

    private String days;

    private String title;

    private String content;

    private Date createTime;

    private String status;

}