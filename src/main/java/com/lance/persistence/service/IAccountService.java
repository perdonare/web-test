package com.lance.persistence.service;

import com.lance.persistence.model.AccountPO;

import java.util.List;

/**
 * Created by perdonare on 2015/7/26.
 */
public interface IAccountService {
    AccountPO getUserByName(String username);
    public List<String> getRoles(String accountName);
}
