package com.tranining.nx2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {
    @Pointcut("execution(* com.tranining.nx2.controller.*.*(..))")
    public  void loggingPointCut() {
        System.out.println("inside loggingPointcut");
    }

    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before invoked method "+joinPoint.getSignature());
    }

    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After invoked method "+joinPoint.getSignature());
    }
}
