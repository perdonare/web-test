package com.lance.persistence.mapper;

import com.lance.persistence.model.RolePO;

public interface RolePOMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePO record);

    int insertSelective(RolePO record);

    RolePO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePO record);

    int updateByPrimaryKey(RolePO record);
}