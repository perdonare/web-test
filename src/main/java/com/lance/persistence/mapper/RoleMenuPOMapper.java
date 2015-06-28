package com.lance.persistence.mapper;

import com.lance.persistence.model.RoleMenuPO;

public interface RoleMenuPOMapper {
    int insert(RoleMenuPO record);

    int insertSelective(RoleMenuPO record);
}