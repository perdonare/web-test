package com.lance.persistence.mapper;

import com.lance.persistence.model.DictPO;

public interface DictPOMapper {
    int insert(DictPO record);

    int insertSelective(DictPO record);
}