package com.lance.persistence.service.impl;

import com.google.common.collect.Lists;
import com.lance.persistence.mapper.MenuPOMapper;
import com.lance.persistence.mapper.RoleMenuPOMapper;
import com.lance.persistence.mapper.RolePOMapper;
import com.lance.persistence.model.MenuPO;
import com.lance.persistence.model.RoleMenuPO;
import com.lance.persistence.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by perdonare on 2015/7/28.
 */
@Service
public class ResourceServiceImpl implements IResourceService{
    @Autowired
    private MenuPOMapper menuPOMapper;
    @Autowired
    private RoleMenuPOMapper roleMenuPOMapper;
    @Autowired
    private RolePOMapper rolePOMapper;
    @Override
    public List<String> getRoles(String resource) {
        MenuPO menuPO = menuPOMapper.getMenuPO(resource);
        if (menuPO==null){
            return null;
        }
        List<RoleMenuPO> roleMenuPOs = roleMenuPOMapper.getRoleMenuPO(menuPO.getId());
        List<String> roles = Lists.newArrayList();
        if (roleMenuPOs!=null && !roleMenuPOs.isEmpty()){
            for(RoleMenuPO roleMenuPO : roleMenuPOs){
                String role = rolePOMapper.selectByPrimaryKey(roleMenuPO.getRoleId()).getRoleName();
                roles.add(role);
            }
        }
        return roles;
    }
}
