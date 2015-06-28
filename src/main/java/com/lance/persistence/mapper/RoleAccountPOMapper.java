package com.lance.persistence.mapper;

import com.lance.persistence.model.RoleAccountPO;

public interface RoleAccountPOMapper {
    int insert(RoleAccountPO record);

    int insertSelective(RoleAccountPO record);
}