package com.example.demo.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class TakeLogAOP {
    Logger logger = LogManager.getLogger("take log");

    @Pointcut("execution(public * com.example.demo..*.*(..))")
    public void logAOP() {
    }

    @Before("logAOP()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.warn("URL : " + request.getRequestURL().toString());
        logger.warn("HTTP_METHOD : " + request.getMethod());
        logger.warn("IP : " + request.getRemoteAddr());
        logger.warn("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.warn("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("logAOP()")
    public void doAfter(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        logger.warn("AFTER FUNCTION CALL " + joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "ret", pointcut = "logAOP()")
    public void doAfterReturning(Object ret) {
        logger.warn("RESPONSE : " + ret);
    }
}
