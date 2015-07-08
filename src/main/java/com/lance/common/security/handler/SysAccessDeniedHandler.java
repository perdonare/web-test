package com.lance.common.security.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by perdonare on 2015/7/4.
 */
public class SysAccessDeniedHandler implements AccessDeniedHandler {
    private String errorPage;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        System.out.println("qqqqqqqqqqqqqq");
        if (!response.isCommitted()){
            if (errorPage!=null){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(errorPage);
                requestDispatcher.forward(request,response);
            } else {
                response.sendError(403,e.getMessage());
            }
        }
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }
}
