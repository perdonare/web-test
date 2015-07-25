package com.lance.common.security.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.util.Assert;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by perdonare on 2015/7/21.
 */
public class SysConcurrentSessionFilter extends GenericFilterBean {
    private SessionRegistry sessionRegistry;
    private String expiredUrl;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private LogoutHandler[] handlers = new LogoutHandler[]{new SecurityContextLogoutHandler()};

    @Override
    public void afterPropertiesSet() throws ServletException {
        Assert.notNull(sessionRegistry);
        Assert.notNull(expiredUrl);

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        if(session != null) {
            SessionInformation info = this.sessionRegistry.getSessionInformation(session.getId());
            if(info != null) {
                if(info.isExpired()) {
                    this.doLogout(request, response);
                    String targetUrl = this.determineExpiredUrl(request, info);
                    if(targetUrl != null) {
                        this.redirectStrategy.sendRedirect(request, response, targetUrl);
                        return;
                    }

                    response.getWriter().print("This session has been expired (possibly due to multiple concurrent logins being attempted as the same user).");
                    response.flushBuffer();
                    return;
                }

                this.sessionRegistry.refreshLastRequest(info.getSessionId());
            }
        }
        chain.doFilter(request,response);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LogoutHandler[] arr$ = this.handlers;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            LogoutHandler handler = arr$[i$];
            handler.logout(request, response, auth);
        }

    }

    private String determineExpiredUrl(HttpServletRequest request, SessionInformation info) {
        return this.expiredUrl;
    }

    public void setSessionRegistry(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void setExpiredUrl(String expiredUrl) {
        this.expiredUrl = expiredUrl;
    }
}
