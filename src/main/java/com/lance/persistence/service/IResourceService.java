package com.lance.persistence.service;

import com.lance.persistence.model.MenuPO;

import java.util.List;

/**
 * Created by perdonare on 2015/7/5.
 */
public interface IResourceService {
    List<MenuPO> getMenusByAccountName(String accountName);
}
