package com.lance.service.impl;

import com.google.common.collect.Lists;
import com.lance.model.AccountBO;
import com.lance.persistence.model.AccountPO;
import com.lance.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by perdonare on 2015/8/16.
 */
@Service(value = "accountServiceImp")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    com.lance.persistence.service.IAccountService accountService;
    @Override
    public List<AccountBO> getAccounts(int pageNum, int pageSize) {
        List<AccountPO> accountPOs = accountService.getAccounts(pageNum,pageSize);
        List<AccountBO> accountBOs = Lists.newArrayList();
        if (accountPOs!=null&&!accountPOs.isEmpty()){
            for (AccountPO accountPO : accountPOs) {
                AccountBO accountBO = convertAccountBO(accountPO);
                accountBOs.add(accountBO);
            }
        }
        return accountBOs;
    }

    private AccountBO convertAccountBO(AccountPO accountPO) {
        AccountBO accountBO = new AccountBO();
        accountBO.setId(accountPO.getId());
        accountBO.setContactEmail(accountPO.getContactEmail());
        accountBO.setContactPhone(accountPO.getContactPhone());
        accountBO.setLoginAccount(accountPO.getLoginAccount());
        return accountBO;
    }
}
