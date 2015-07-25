package com.lance.persistence.service.impl;

import com.google.common.collect.Lists;
import com.lance.persistence.mapper.AccountPOMapper;
import com.lance.persistence.mapper.MenuPOMapper;
import com.lance.persistence.mapper.RoleMenuPOMapper;
import com.lance.persistence.mapper.RolePOMapper;
import com.lance.persistence.model.MenuPO;
import com.lance.persistence.model.RoleMenuPO;
import com.lance.persistence.model.RolePO;
import com.lance.persistence.service.IResourceService;
import com.sun.org.apache.bcel.internal.generic.I2F;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by perdonare on 2015/7/5.
 */
@Service
public class ResourceServiceImpl implements IResourceService {
    @Autowired
    private MenuPOMapper menuPOMapper;
    @Autowired
    private RoleMenuPOMapper roleMenuPOMapper;
    @Autowired
    private RolePOMapper rolePOMapper;
    @Override
    public List<MenuPO> getMenusByAccountName(String accountName) {
        return null;
    }

    @Override
    public List<RolePO> getRolsByResource(String resource) {
        MenuPO menuPO = menuPOMapper.getByResourceName(resource);
        if (menuPO == null) {
            return null;
        }
        List<RoleMenuPO> roleMenuPOs = roleMenuPOMapper.getRoleMenuByResourceId(menuPO.getId());
        List<RolePO> rolePOs = Lists.newArrayList();
        for (RoleMenuPO roleMenuPO : roleMenuPOs) {
            RolePO rolePO = rolePOMapper.selectById(roleMenuPO.getRoleId());
            rolePOs.add(rolePO);
        }
        return rolePOs;
    }
}
