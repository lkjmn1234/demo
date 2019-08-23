package com.example.demo.config;

import com.example.demo.interceptor.web.DemoInterceptor;
import javax.inject.Inject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan({"com.example.demo.aop", "com.example.demo.filter",
    "com.example.demo.interceptor.*"})
public class WebInterceptorConfig extends WebMvcConfigurationSupport {

  @Inject
  DemoInterceptor demoInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(demoInterceptor);
  }
}
