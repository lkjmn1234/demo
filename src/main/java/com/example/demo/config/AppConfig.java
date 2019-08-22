package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.demo.rest.controller", "com.example.demo.service", "com.example.demo.aop", "com.example.demo.filter"})
public class AppConfig {
}
