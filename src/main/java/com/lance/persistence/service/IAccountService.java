package com.lance.persistence.service;

import com.lance.persistence.model.AccountPO;
import com.lance.persistence.model.User;

import java.util.List;

/**
 * Created by perdonare on 2015/5/2.
 */
public interface IAccountService {

    public List<AccountPO> getUsers();
}
