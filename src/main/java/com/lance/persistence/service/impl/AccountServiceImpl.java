package com.lance.persistence.service.impl;

import com.lance.persistence.mapper.AccountPOMapper;
import com.lance.persistence.model.AccountPO;
import com.lance.persistence.service.IAccountService;
import org.springframework.security.web.authentication.session.CompositeSessionAuthenticationStrategy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by perdonare on 2015/7/26.
 */
@Service
public class AccountServiceImpl implements IAccountService{
    @Resource
    private AccountPOMapper accountPOMapper;
    @Override
    public AccountPO getUserByName(String accountName) {
        return accountPOMapper.getAccountByName(accountName);
    }
}
