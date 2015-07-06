package com.lance.persistence.service.impl;

import com.lance.persistence.mapper.AccountPOMapper;
import com.lance.persistence.mapper.MenuPOMapper;
import com.lance.persistence.mapper.RoleMenuPOMapper;
import com.lance.persistence.model.MenuPO;
import com.lance.persistence.model.RoleMenuPO;
import com.lance.persistence.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by perdonare on 2015/7/5.
 */
@Service
public class ResourceServiceImpl implements IResourceService {
    @Autowired
    private AccountPOMapper accountPOMapper;
    @Autowired
    private MenuPOMapper menuPOMapper;
    @Autowired
    private RoleMenuPOMapper roleMenuPOMapper;
    @Override
    public List<MenuPO> getMenusByAccountName(String accountName) {
        return null;
    }
}
