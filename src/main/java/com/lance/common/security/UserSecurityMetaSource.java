package com.lance.common.security;

import com.google.common.collect.Lists;
import com.lance.persistence.service.IAccountService;
import com.lance.persistence.service.IResourceService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.List;

/**
 * Created by perdonare on 2015/7/28.
 */
public class UserSecurityMetaSource implements FilterInvocationSecurityMetadataSource {
    private IResourceService resourceService;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        String url = filterInvocation.getRequestUrl();
        List<String> roles = resourceService.getRoles(url);
        System.out.println("======"+url);
        Collection<ConfigAttribute> attributes = Lists.newArrayList();
        if (roles!=null&&!roles.isEmpty()){
            for (String role : roles){
                ConfigAttribute securityConfig = new SecurityConfig(role);
                attributes.add(securityConfig);
            }
        }
        return attributes;

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
