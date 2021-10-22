package com.example.component.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SecurityAspect {

    @Around(value = "execution(* com.example.Application(..))")
    public Object securityAspect(ProceedingJoinPoint pjp) throws Throwable {

        return pjp.proceed();
    }
}
