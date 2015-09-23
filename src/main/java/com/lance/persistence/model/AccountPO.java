package com.lance.persistence.model;

import lombok.Data;

import java.util.Date;

@Data
public class AccountPO {
    private String id;

    private String loginAccount;

    private String loginPassword;

    private String loginType;

    private String contactPhone;

    private String contactEmail;

    private String userId;

    private String userName;

    private String isSystem;

    private String isClose;

    private Date createTime;

    private Date checkTime;

    private String createUid;

    private String updateUid;

    private String checkUid;

    private String checkFlag;
}