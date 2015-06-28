package com.lance.persistence.mapper;

import com.lance.persistence.model.AccountPO;

public interface AccountPOMapper {
    int insert(AccountPO record);

    int insertSelective(AccountPO record);

    AccountPO select(String loginAccount,String loginPassword);
}