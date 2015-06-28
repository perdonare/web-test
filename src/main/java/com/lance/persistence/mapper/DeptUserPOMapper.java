package com.lance.persistence.mapper;

import com.lance.persistence.model.DeptUserPO;

public interface DeptUserPOMapper {
    int insert(DeptUserPO record);

    int insertSelective(DeptUserPO record);
}