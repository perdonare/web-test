package com.lance.persistence.mapper;

import com.lance.persistence.model.OnlineUserPO;

public interface OnlineUserPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(OnlineUserPO record);

    int insertSelective(OnlineUserPO record);

    OnlineUserPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OnlineUserPO record);

    int updateByPrimaryKey(OnlineUserPO record);
}