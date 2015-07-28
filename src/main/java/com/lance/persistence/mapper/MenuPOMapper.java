package com.lance.persistence.mapper;

import com.lance.persistence.model.MenuPO;

public interface MenuPOMapper {
    MenuPO getMenuPO(String menu);
    int deleteByPrimaryKey(String id);

    int insert(MenuPO record);

    int insertSelective(MenuPO record);

    MenuPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MenuPO record);

    int updateByPrimaryKey(MenuPO record);
}