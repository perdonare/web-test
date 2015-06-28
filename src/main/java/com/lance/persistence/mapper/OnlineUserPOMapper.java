package com.lance.persistence.mapper;

import com.lance.persistence.model.OnlineUserPO;

public interface OnlineUserPOMapper {
    int insert(OnlineUserPO record);

    int insertSelective(OnlineUserPO record);
}