package com.lance.persistence.mapper;

import com.lance.persistence.model.ConfigPO;

public interface ConfigPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(ConfigPO record);

    int insertSelective(ConfigPO record);

    ConfigPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ConfigPO record);

    int updateByPrimaryKey(ConfigPO record);
}