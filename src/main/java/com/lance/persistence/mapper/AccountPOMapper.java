package com.lance.persistence.mapper;

import com.lance.persistence.model.AccountPO;

import java.util.List;
import java.util.Map;

public interface AccountPOMapper {
    AccountPO getAccountByName(String accountName);

    int deleteByPrimaryKey(String id);

    int insert(AccountPO record);

    int insertSelective(AccountPO record);

    AccountPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AccountPO record);

    int updateByPrimaryKey(AccountPO record);

    List<AccountPO> selectAll(Map map);
}