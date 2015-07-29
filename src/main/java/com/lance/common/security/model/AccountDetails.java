package com.lance.common.security.model;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by perdonare on 2015/7/26.
 */
public class AccountDetails implements UserDetails {
    private String accountName;
    private String password;
    private boolean accountNotExpired;
    private boolean accountNotLocked;
    private boolean credentialsNonExpired;
    private boolean enable;
    public AccountDetails(String accountName,String password){
        this.accountName = accountName;
        this.password = password;
        this.accountNotExpired = true;
        this.accountNotLocked = true;
        this.credentialsNonExpired = true;
        this.enable = true;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List temp = Lists.newArrayList();
        temp.add(new SimpleGrantedAuthority("ADMIN"));
        return temp;
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
}
