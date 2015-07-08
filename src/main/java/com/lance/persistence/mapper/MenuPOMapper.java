package com.lance.persistence.mapper;

import com.lance.persistence.model.MenuPO;

public interface MenuPOMapper {
    MenuPO getByResourceName(String resourceName);
}