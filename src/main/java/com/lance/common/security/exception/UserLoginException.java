package com.lance.common.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by perdonare on 2015/6/27.
 */
public class UserLoginException extends AuthenticationException {
    public UserLoginException(String message) {
        super(message);
    }

    public UserLoginException(String message, Throwable t) {
        super(message, t);
    }
}
