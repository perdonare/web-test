package com.lance.persistence.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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
import java.util.Map;

/**
 * Created by perdonare on 2015/7/26.
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
    public AccountPO getUserByName(String accountName) {
        return accountPOMapper.getAccountByName(accountName);
    }

    public List<String> getRoles(String accountName){
        AccountPO accountPO = getUserByName(accountName);
        if (accountPO==null){
            return null;
        }
        List<RoleAccountPO> roleAccountPOs = roleAccountPOMapper.getRoleAccountPO(accountPO.getId());
        List<String> roles = Lists.newArrayList();
        if (roleAccountPOs!=null){
            for (RoleAccountPO roleAccountPO : roleAccountPOs) {
                RolePO rolePO = rolePOMapper.selectByPrimaryKey(roleAccountPO.getRoleId());
                roles.add(rolePO.getRoleName());
            }
        }
        return roles;
    }

    @Override
    public List<AccountPO> getAccounts(int pageNum, int pageSize) {
        Map<String,Object> map = Maps.newHashMap();
        map.put("startPage",pageNum);
        map.put("endPage",pageNum+pageSize);
        return  accountPOMapper.selectAll(map);
    }
}
