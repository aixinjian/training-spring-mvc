package com.training.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJ {

    @Pointcut("execution(* com.training..*.*(..))")
    public void pointCunt() {

    }

    @Before("pointCunt()")
    public void before() {
        System.out.println(22222222);
        System.out.println("切点进行中");
    }
}
