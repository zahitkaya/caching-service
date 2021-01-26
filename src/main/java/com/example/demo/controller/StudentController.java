package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
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
