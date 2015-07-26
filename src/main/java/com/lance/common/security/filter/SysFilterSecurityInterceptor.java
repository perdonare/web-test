package com.lance.common.security.filter;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Created by perdonare on 2015/7/4.
 */
public class SysFilterSecurityInterceptor extends FilterSecurityInterceptor implements Filter{
    private static final String APPLIED = "applied_authentication";



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURL().toString();
        if (url.equals("/") || url.equals("/login/loginForm") || url.equals("/index.jsp")){
            return;
        }
        FilterInvocation fi = new FilterInvocation(request,response,chain);
        invoke(fi);
    }

    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        HttpServletRequest request = fi.getRequest();
        if (request!=null && request.getAttribute(APPLIED) != null){
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } else {
            if (fi.getRequest() != null) {
                fi.getRequest().setAttribute(APPLIED, Boolean.TRUE);
            }
            InterceptorStatusToken token = super.beforeInvocation(fi);

            try {
                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
            }
            finally {
                super.finallyInvocation(token);
            }

            super.afterInvocation(token, null);
        }

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return getSecurityMetadataSource();
    }
}
