package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class PageableAspect {


    @Pointcut("within(com.example.demo.controller..*)" + "&& execution(* *..get*(org.springframework.data.domain.Pageable)))")
    public void getNamePointcut(){
    }
    @Before("getNamePointcut()")
    public void deneme(){
        log.info("1234");
    }
}
