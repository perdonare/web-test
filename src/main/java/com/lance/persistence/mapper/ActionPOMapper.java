package com.lance.persistence.mapper;

import com.lance.persistence.model.ActionPO;

public interface ActionPOMapper {
    int insert(ActionPO record);

    int insertSelective(ActionPO record);
}