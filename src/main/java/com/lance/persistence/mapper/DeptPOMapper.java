package com.lance.persistence.mapper;

import com.lance.persistence.model.DeptPO;

public interface DeptPOMapper {
    int insert(DeptPO record);

    int insertSelective(DeptPO record);
}