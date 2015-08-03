package com.lance.persistence.mapper;

import com.lance.persistence.model.AccountPO;

import java.util.List;

public interface AccountPOMapper {

    List<AccountPO> queryUsers();

    int deleteByPrimaryKey(Integer id);

    int insert(AccountPO record);

    int insertSelective(AccountPO record);

    AccountPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountPO record);

    int updateByPrimaryKey(AccountPO record);
}