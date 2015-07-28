package com.lance.persistence.mapper;

import com.lance.persistence.model.RoleMenuPO;

import java.util.List;

public interface RoleMenuPOMapper {
    List<RoleMenuPO> getRoleMenuPO(String menuId);
    int deleteByPrimaryKey(String id);

    int insert(RoleMenuPO record);

    int insertSelective(RoleMenuPO record);

    RoleMenuPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleMenuPO record);

    int updateByPrimaryKey(RoleMenuPO record);
}