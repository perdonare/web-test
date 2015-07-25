package com.lance.common.security.filter;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;


/**
 * Created by perdonare on 2015/7/4.
 */
public class SysFilterSecurityInterceptor extends FilterSecurityInterceptor {


}
