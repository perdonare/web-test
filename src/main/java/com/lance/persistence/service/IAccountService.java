package com.lance.persistence.service;

import com.lance.persistence.model.AccountPO;

/**
 * Created by perdonare on 2015/7/26.
 */
public interface IAccountService {
    AccountPO getUserByName(String username);
}
