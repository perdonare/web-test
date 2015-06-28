package com.lance.persistence.mapper;

import com.lance.persistence.model.NotifyPO;

public interface NotifyPOMapper {
    int insert(NotifyPO record);

    int insertSelective(NotifyPO record);
}