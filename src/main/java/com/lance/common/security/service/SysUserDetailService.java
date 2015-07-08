package com.lance.common.security.service;

import com.google.common.collect.Lists;
import com.lance.common.security.model.SysRole;
import com.lance.common.security.model.SysUser;
import com.lance.persistence.model.AccountPO;
import com.lance.persistence.model.RolePO;
import com.lance.persistence.service.IAccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.List;

/**
 * Created by perdonare on 2015/7/5.
 */
public class SysUserDetailService implements UserDetailsService {
    private IAccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("==========================");
        AccountPO accountPO = accountService.getAccountPO(username);
        if (accountPO==null)
            throw new UsernameNotFoundException("用户未找到");
        String password = accountPO.getLoginPassword();
        SysUser sysUser = new SysUser(username,password,getSysRoles(accountPO));
        return sysUser;
    }

    private List<SysRole> getSysRoles(AccountPO accountPO){

        List<RolePO> rolePOs = accountService.getRolesByAccountId(accountPO.getId());
        List<SysRole> sysRoles = Lists.newArrayList();
        for (RolePO rolePO : rolePOs) {
            SysRole sysRole = new SysRole();
            sysRole.setRoleName(rolePO.getRoleName());
            sysRoles.add(sysRole);
        }
        return sysRoles;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
