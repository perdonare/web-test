package com.lance.common.security.filter;

import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * Created by perdonare on 2015/7/4.
 */
public class SysLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint{
    public SysLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }
}
