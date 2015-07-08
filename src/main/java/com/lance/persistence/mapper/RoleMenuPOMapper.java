package com.lance.persistence.mapper;

import com.lance.persistence.model.RoleMenuPO;

import java.util.List;

public interface RoleMenuPOMapper {
    List<RoleMenuPO> getRoleMenuByResourceId(String resourceId);
}