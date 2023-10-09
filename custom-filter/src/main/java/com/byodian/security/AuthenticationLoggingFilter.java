package com.byodian.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationLoggingFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(AuthenticationLoggingFilter.class);

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;

        var requestId = httpRequest.getHeader("Request-Id");
        logger.info("Successfully authenticated request with id: " + requestId);
        chain.doFilter(request, response);
    }
}
