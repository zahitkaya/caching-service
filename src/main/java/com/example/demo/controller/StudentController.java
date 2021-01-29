package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequiredArgsConstructor
public class StudentController
{

    final StudentService studentService;
    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable int id)
    {
        return studentService.getStudentByID(id);
    }



    @PageableAsQueryParam
    @GetMapping("/student")
    public Page<Student> getAllStudents(@Parameter(hidden = true) Pageable pageable){
        return studentService.getAllStudents(pageable);
    }

    @PostMapping("/student")
    public Student addNewStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }
}
