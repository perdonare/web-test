package com.lance.persistence.mapper;

import com.lance.persistence.model.DictPO;

public interface DictPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(DictPO record);

    int insertSelective(DictPO record);

    DictPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DictPO record);

    int updateByPrimaryKey(DictPO record);
}