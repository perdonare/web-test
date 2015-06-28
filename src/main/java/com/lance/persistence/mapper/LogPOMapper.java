package com.lance.persistence.mapper;

import com.lance.persistence.model.LogPO;

public interface LogPOMapper {
    int insert(LogPO record);

    int insertSelective(LogPO record);
}