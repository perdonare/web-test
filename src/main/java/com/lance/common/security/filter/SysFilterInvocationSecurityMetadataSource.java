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

import com.lance.persistence.mapper.MenuPOMapper;
import com.lance.persistence.service.IResourceService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import java.util.Collection;
import java.util.List;

public class SysFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private IResourceService resourceService;

    private RequestMatcher pathMatcher = null;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        String url = filterInvocation.getRequestUrl();
        Collection<ConfigAttribute> configAttributes = Lists.newArrayList();
        ConfigAttribute configAttribute = new SecurityConfig("lance");
        configAttributes.add(configAttribute);
        return configAttributes;

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
