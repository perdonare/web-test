package com.lance.persistence.mapper;

import com.lance.persistence.model.RoleAccountPO;

import java.util.List;

public interface RoleAccountPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleAccountPO record);

    int insertSelective(RoleAccountPO record);

    RoleAccountPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleAccountPO record);

    int updateByPrimaryKey(RoleAccountPO record);

    List<RoleAccountPO> getRoleAccountPOs(String accountId);
}