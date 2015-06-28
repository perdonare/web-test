package com.lance.persistence.mapper;

import com.lance.persistence.model.UserPO;

public interface UserPOMapper {
    int insert(UserPO record);

    int insertSelective(UserPO record);
}