package com.lance.persistence.mapper;

import com.lance.persistence.model.AccountPO;

public interface AccountPOMapper {
    AccountPO getByUsername(String loginAccount);
}