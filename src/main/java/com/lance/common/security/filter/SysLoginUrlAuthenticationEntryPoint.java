package com.lance.common.security.filter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by perdonare on 2015/7/4.
 */
public class SysLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint{
    public SysLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("redirect=============");
        response.sendRedirect(getLoginFormUrl());
        response.flushBuffer();
    }


}
