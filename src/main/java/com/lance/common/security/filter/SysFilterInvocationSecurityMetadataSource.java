/************************************************************************************
 * Copyright (c) 2014 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      SysFilterInvocationSecurityMetadataSource.java
 * Create on:      2014/12/22 13:48
 * Author :        yxd
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2014/12/22 13:48			            yxd						     Create
 ************************************************************************************/
package com.lance.common.security.filter;
import com.google.common.collect.Lists;

import com.lance.persistence.model.RolePO;
import com.lance.persistence.service.IResourceService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.List;

public class SysFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private IResourceService resourceService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        String url = filterInvocation.getRequestUrl();
        List<RolePO> rolePOs = resourceService.getRolsByResource(url);
        if (rolePOs == null || rolePOs.size()==0){
             throw new AccessDeniedException("拒绝登陆");
        }
        List<ConfigAttribute> configAttributes = Lists.newArrayList();
        for (RolePO rolePO : rolePOs) {
            ConfigAttribute configAttribute = new SecurityConfig(rolePO.getRoleName());
            configAttributes.add(configAttribute);
        }
        if (configAttributes.size()>0) {
            return configAttributes;

        }
        throw new AccessDeniedException("拒绝登陆");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    public void setResourceService(IResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
