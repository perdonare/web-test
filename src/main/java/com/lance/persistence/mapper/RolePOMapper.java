package com.lance.persistence.mapper;

import com.lance.persistence.model.RolePO;

public interface RolePOMapper {
    int insert(RolePO record);

    int insertSelective(RolePO record);
}