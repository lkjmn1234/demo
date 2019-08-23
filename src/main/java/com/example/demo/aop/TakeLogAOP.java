package com.example.demo.aop;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class TakeLogAOP {

  Logger logger = LogManager.getLogger("take log");

  @Pointcut("execution(public * com.example.demo..*.*(..))")
  public void logAOP() {
  }

  @Before("logAOP()")
  public void doBefore(JoinPoint joinPoint) {
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    logger.warn("GET IN FUNCTION CALL: " + joinPoint.getSignature().getName());
  }

  @After("logAOP()")
  public void doAfter(JoinPoint joinPoint) {
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes();
    logger.warn("AFTER FUNCTION CALL " + joinPoint.getSignature().getName());
  }

  @AfterReturning(returning = "ret", pointcut = "logAOP()")
  public void doAfterReturning(Object ret) {
    logger.warn("RETURNING OBJECT : " + ret);
  }
}
