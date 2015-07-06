package com.lance.persistence.service.impl;

import com.google.common.collect.Lists;
import com.lance.persistence.mapper.AccountPOMapper;
import com.lance.persistence.mapper.RoleAccountPOMapper;
import com.lance.persistence.mapper.RolePOMapper;
import com.lance.persistence.model.AccountPO;
import com.lance.persistence.model.RoleAccountPO;
import com.lance.persistence.model.RolePO;
import com.lance.persistence.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by perdonare on 2015/6/27.
 */
@Service
public class AccountServiceImpl implements IAccountService{
    @Autowired
    private AccountPOMapper accountPOMapper;
    @Autowired
    private RolePOMapper rolePOMapper;
    @Autowired
    private RoleAccountPOMapper roleAccountPOMapper;

    @Override
    public AccountPO getAccountPO(String name) {
        return accountPOMapper.getByUsername(name);
    }

    public List<RolePO> getRolesByAccountId(String accountId) {
        List<RoleAccountPO> roleAccountPOs = roleAccountPOMapper.getRoleAccountPOs(accountId);
        List<RolePO> rolePOs = Lists.newArrayList();
        for (RoleAccountPO roleAccountPO:roleAccountPOs){
            RolePO rolePO = rolePOMapper.selectById(roleAccountPO.getRoleId());
            rolePOs.add(rolePO);
        }
        return  rolePOs;
    }

    @Override
    public boolean checkAccountExist(String username, String password) {
        AccountPO accountPO = getAccountPO(username);
        if (accountPO.getLoginPassword().equals(password))
            return true;
        return false;
    }

}
