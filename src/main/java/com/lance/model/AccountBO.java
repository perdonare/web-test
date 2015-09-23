package com.lance.model;

import lombok.Data;

/**
 * Created by perdonare on 2015/8/16.
 */
@Data
public class AccountBO {
    private String id;

    private String loginAccount;

    private String loginType;

    private String contactPhone;

    private String contactEmail;

    private String userId;

    private String userName;

    private String encryKey;
}
