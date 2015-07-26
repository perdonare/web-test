package com.lance.persistence.mapper;

import com.lance.persistence.model.DeptUserPO;

public interface DeptUserPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(DeptUserPO record);

    int insertSelective(DeptUserPO record);

    DeptUserPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DeptUserPO record);

    int updateByPrimaryKey(DeptUserPO record);
}