package com.example.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author chang qi
 * @date 2025/2/17
 */
@Slf4j
@Aspect
@Component
public class UserServiceAspect {

    @Around("execution(* com.example.aop.service.IUserService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("aspect in ...");
        Object retVal = joinPoint.proceed();
        log.info("aspect out...");
        return retVal;
    }

}
