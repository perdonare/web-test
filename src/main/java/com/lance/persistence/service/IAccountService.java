package com.lance.persistence.service;

import com.lance.common.security.model.SysRole;
import com.lance.persistence.model.AccountPO;
import com.lance.persistence.model.RolePO;

import java.util.List;

/**
 * Created by perdonare on 2015/6/27.
 */
public interface IAccountService {
    AccountPO getAccountPO(String name);
    List<RolePO> getRolesByAccountId(String id);
    boolean checkAccountExist(String username,String password);
}
