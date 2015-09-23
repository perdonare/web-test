package com.lance.service;

import com.lance.model.AccountBO;

import java.util.List;

/**
 * Created by perdonare on 2015/8/16.
 */
public interface IAccountService {
    List<AccountBO> getAccounts(int pageNum,int pageSize);
}
