package com.byodian.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationLoggingFilter implements Filter {
    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;

        var requestId = httpRequest.getHeader("Request-Id");
        System.out.println("Successfully authenticated request with id: " + requestId);
        chain.doFilter(request, response);
    }
}
