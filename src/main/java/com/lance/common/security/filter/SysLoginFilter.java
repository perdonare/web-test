package com.lance.common.security.filter;

import com.lance.persistence.service.IAccountService;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by perdonare on 2015/7/4.
 */
public class SysLoginFilter extends UsernamePasswordAuthenticationFilter {
    //private IAccountService accountService;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("================");
        String username  = getUsername(request);
        String password  = getPassword(request);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
        setDetails(request,token);
        System.out.println("======================");
        return getAuthenticationManager().authenticate(token);
    }

    public String getUsername(HttpServletRequest request){
        String username = request.getParameter("username");
        if (username==null||username.trim().equals(""))
            throw new UsernameNotFoundException("用户名为空");
        return username;
    }
    public String getPassword(HttpServletRequest request){
        String password = request.getParameter("password");
        if (password==null||password.trim().equals(""))
            throw new UsernameNotFoundException("密码为空");
        return password;
    }

    /*public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }*/
}
