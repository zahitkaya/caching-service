package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springdoc.core.converters.models.PageableAsQueryParam;

@Aspect
public class StudentAspect {
    @Before("execution(* com.example.demo.controller.StudentController.getAllStudents())")
    public void setQuery(){
    }
}
