package com.lance.common.security.model;

import com.google.common.collect.Lists;
import com.lance.persistence.service.IAccountService;
import com.lance.persistence.service.impl.AccountServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by perdonare on 2015/7/26.
 */

public class AccountDetails implements UserDetails,ApplicationContextAware{
    private  ApplicationContext applicationContext;
    private String accountName;
    private String password;
    private List<String> roles;
    private boolean accountNotExpired;
    private boolean accountNotLocked;
    private boolean credentialsNonExpired;
    private boolean enable;
    public AccountDetails(String accountName,String password,List<String> roles){
        this.accountName = accountName;
        this.password = password;
        this.accountNotExpired = true;
        this.accountNotLocked = true;
        this.credentialsNonExpired = true;
        this.enable = true;
        this.roles = roles;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority>  authorities = Lists.newArrayList();
        if (roles!=null){
            for (String role : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
                authorities.add(authority);
            }
            return authorities;
        }
        return null;
        /*IAccountService accountService = applicationContext.getBean("accountServiceImpl",AccountServiceImpl.class);
        if (accountName!=null) {
            List<String> roles = accountService.getRoles(accountName);
            Collection<GrantedAuthority>  authorities = Lists.newArrayList();
            if (roles!=null){
                for (String role : roles) {
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
                    authorities.add(authority);
                }
                return authorities;
            }
        }

        return null;*/
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return accountName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNotExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNotLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
