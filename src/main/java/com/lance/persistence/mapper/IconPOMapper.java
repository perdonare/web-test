package com.lance.persistence.mapper;

import com.lance.persistence.model.IconPO;

public interface IconPOMapper {
    int insert(IconPO record);

    int insertSelective(IconPO record);
}