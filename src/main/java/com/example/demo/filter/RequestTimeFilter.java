package com.example.demo.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestTimeFilter extends OncePerRequestFilter {
    Logger logger = LogManager.getLogger("request");


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        long time = System.currentTimeMillis();
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } finally {
            time = System.currentTimeMillis() - time;
            logger.info("{}: {} ms ", httpServletRequest.getRequestURI(), time);
        }
    }
}