package com.lance.common.security.filter;

import com.lance.common.security.exception.UserLoginException;
import com.lance.persistence.service.IAccountService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by perdonare on 2015/6/27.
 */
public class UserLoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private boolean verifyCode = true;
    IAccountService accountService;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");
        boolean existFlag = accountService.checkAccountExist(username,password);
        UsernamePasswordAuthenticationToken authRequest = null;
        if (existFlag){
            username = username.trim();
            authRequest = new UsernamePasswordAuthenticationToken(username, password);
            setDetails(request,authRequest);
        } else {
            throw new UserLoginException("无法获取相关用户");
        }
        setDetails(request,authRequest);
        return getAuthenticationManager().authenticate(authRequest);
    }


    public void setVerifyCode(boolean verifyCode) {
        this.verifyCode = verifyCode;
    }
}
