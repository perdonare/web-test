package com.lance.persistence.mapper;

import com.lance.persistence.model.NotifyPO;

public interface NotifyPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(NotifyPO record);

    int insertSelective(NotifyPO record);

    NotifyPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NotifyPO record);

    int updateByPrimaryKey(NotifyPO record);
}