package com.lance.persistence.mapper;

import com.lance.persistence.model.ActionPO;

public interface ActionPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActionPO record);

    int insertSelective(ActionPO record);

    ActionPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActionPO record);

    int updateByPrimaryKey(ActionPO record);
}