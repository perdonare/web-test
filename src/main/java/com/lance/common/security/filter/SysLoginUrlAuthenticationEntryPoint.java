package com.lance.common.security.filter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by perdonare on 2015/7/4.
 */
public class SysLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint{
    public SysLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("===============");
        PrintWriter writer = null;
        String redirectUrl=buildRedirectUrlToLoginPage(request,response,authException);
        String contextPath=request.getContextPath();
        if (!UrlUtils.isAbsoluteUrl(redirectUrl)) {
            redirectUrl= contextPath + redirectUrl;
        }
        response.setContentType("text/html;charset=UTF-8");
        String loginLoseStr="<script>top.location.href='"+redirectUrl+"'</script>";
        writer = response.getWriter();
        writer.write(loginLoseStr);
        writer.flush();

    }
}
