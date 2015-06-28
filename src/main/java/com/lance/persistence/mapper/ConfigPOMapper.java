package com.lance.persistence.mapper;

import com.lance.persistence.model.ConfigPO;

public interface ConfigPOMapper {
    int insert(ConfigPO record);

    int insertSelective(ConfigPO record);
}