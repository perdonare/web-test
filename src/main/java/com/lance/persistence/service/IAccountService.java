package com.lance.persistence.service;

import com.lance.persistence.model.AccountPO;

/**
 * Created by perdonare on 2015/6/27.
 */
public interface IAccountService {
    public AccountPO getAccountPO(String name , String password);
    public boolean checkAccountExist(String name,String password);
}
