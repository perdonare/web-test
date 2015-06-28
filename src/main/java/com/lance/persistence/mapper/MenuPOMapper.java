package com.lance.persistence.mapper;

import com.lance.persistence.model.MenuPO;

public interface MenuPOMapper {
    int insert(MenuPO record);

    int insertSelective(MenuPO record);
}