package com.lance.common.security.handler;

import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;

/**
 * Created by perdonare on 2015/7/4.
 */
public class SysConcurrentSessionStrategy extends ConcurrentSessionControlAuthenticationStrategy {
    public SysConcurrentSessionStrategy(SessionRegistry sessionRegistry) {
        super(sessionRegistry);
    }
}
