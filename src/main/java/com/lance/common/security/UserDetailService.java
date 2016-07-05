package com.lance.common.security;

import com.lance.common.security.model.AccountDetails;
import com.lance.persistence.model.AccountPO;
import com.lance.persistence.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2015/7/26.
 */

public class UserDetailService implements UserDetailsService{
    private IAccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountPO accountPO = accountService.getUserByName(username);
        if ( accountPO == null ) {
            throw new UsernameNotFoundException("");
        }
        UserDetails userDetails = createUserDetails(accountPO);
        return userDetails;
    }

    private AccountDetails createUserDetails(AccountPO accountPO) {
        AccountDetails accountDetails = new AccountDetails(accountPO.getLoginAccount(),accountPO.getLoginPassword(),accountService.getRoles(accountPO.getLoginAccount()));
        return accountDetails;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
