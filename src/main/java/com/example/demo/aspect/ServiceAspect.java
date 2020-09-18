package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    /**
      * 切面
     */
    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public void point(){

    }

    @Before("point()")
    public void log(JoinPoint joinPoint){
        Class<?> aClass = joinPoint.getTarget().getClass();
        String name = joinPoint.getSignature().getName();
    }
}
