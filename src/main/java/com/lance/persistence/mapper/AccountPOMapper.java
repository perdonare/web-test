package com.lance.persistence.mapper;

import com.lance.persistence.model.AccountPO;

public interface AccountPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(AccountPO record);

    int insertSelective(AccountPO record);

    AccountPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AccountPO record);

    int updateByPrimaryKey(AccountPO record);
}