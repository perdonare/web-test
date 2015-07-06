package com.lance.persistence.mapper;

import com.lance.persistence.model.DeptPO;

public interface DeptPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeptPO record);

    int insertSelective(DeptPO record);

    DeptPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeptPO record);

    int updateByPrimaryKey(DeptPO record);
}