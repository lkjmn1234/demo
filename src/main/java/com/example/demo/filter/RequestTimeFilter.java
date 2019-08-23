package com.example.demo.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class RequestTimeFilter extends OncePerRequestFilter {

  Logger logger = LogManager.getLogger("request");


  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    long time = System.currentTimeMillis();
    try {
      filterChain.doFilter(httpServletRequest, httpServletResponse);
    } finally {
      time = System.currentTimeMillis() - time;
      logger.info("{}: {} ms ", httpServletRequest.getRequestURI(), time);
    }
  }
}