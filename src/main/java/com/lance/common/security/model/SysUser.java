package com.lance.common.security.model;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by perdonare on 2015/7/5.
 */
public class SysUser implements UserDetails {

    private String username;
    private String password;
    private List<SysRole> sysRoles;
    private boolean accountNotExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enable;
    private List<GrantedAuthority> authorities;
    public SysUser() {
        accountNotExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enable = true;
    }

    public SysUser(String username, String password,List<SysRole> roles) {
        accountNotExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enable = true;
        this.username = username;
        this.password = password;
        this.sysRoles = roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNotExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        for (SysRole sysRole : sysRoles){
            grantedAuthorities.add(new SimpleGrantedAuthority(sysRole.getRoleName()));
        }
        return grantedAuthorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public void setAccountNotExpired(boolean accountNotExpired) {
        this.accountNotExpired = accountNotExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
