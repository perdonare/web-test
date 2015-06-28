package com.lance.persistence.service.impl;

import com.lance.persistence.mapper.AccountPOMapper;
import com.lance.persistence.model.AccountPO;
import com.lance.persistence.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/6/27.
 */
@Service
public class AccountServiceImpl implements IAccountService{
    @Autowired
    private AccountPOMapper accountPOMapper;

    @Override
    public AccountPO getAccountPO(String name, String password) {
        return accountPOMapper.select(name,password);
    }

    @Override
    public boolean checkAccountExist(String name, String password) {
        return false;
    }

    public void setAccountPOMapper(AccountPOMapper accountPOMapper) {
        this.accountPOMapper = accountPOMapper;
    }
}
