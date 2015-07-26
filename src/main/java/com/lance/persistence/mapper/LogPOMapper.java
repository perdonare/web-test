package com.lance.persistence.mapper;

import com.lance.persistence.model.LogPO;

public interface LogPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(LogPO record);

    int insertSelective(LogPO record);

    LogPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LogPO record);

    int updateByPrimaryKey(LogPO record);
}