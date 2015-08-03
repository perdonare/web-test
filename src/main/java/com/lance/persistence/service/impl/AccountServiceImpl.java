package com.lance.persistence.service.impl;

import com.lance.persistence.mapper.AccountPOMapper;
import com.lance.persistence.model.AccountPO;
import com.lance.persistence.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by perdonare on 2015/5/2.
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private AccountPOMapper accountPOMapper;


    @Override
    public List<AccountPO> getUsers() {
        return accountPOMapper.queryUsers();
    }


    public void setAccountPOMapper(AccountPOMapper accountPOMapper) {
        this.accountPOMapper = accountPOMapper;
    }
}
