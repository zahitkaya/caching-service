package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class StudentService
{
    final StudentRepository studentRepository;

    @Cacheable(value = "student",key = "#id")
    public Student getStudentByID(int id)
    {
        try {
            log.info("The system is paused for 3 sec");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return studentRepository.findById(id).get();
    }

    @Cacheable(value = "students")
    public List <Student> getAllStudents(){
        try {
            log.info("The system is paused for 3 sec");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return studentRepository.findAll();
    }



    public Student addStudent(Student student){
        try {
            log.info("The system is paused for 3 sec");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return studentRepository.save(student);
    }

    @CachePut(value = "student",key = "#id")
    @CacheEvict(value = "students",allEntries = true)
    public Student updateStudent(int id,Student student){
        try {
            log.info("The system is paused for 3 sec");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        var exStudent=studentRepository.findById(id).get();
        exStudent.setName(student.getName());
        exStudent.setSurname(student.getSurname());
        studentRepository.save(exStudent);
        return exStudent;
    }

    @Caching(evict = {
            @CacheEvict(value = "student",key = "#id"),
            @CacheEvict(value = "students",allEntries = true)
    })

    public void deleteStudent(int id){
        studentRepository.delete(studentRepository.findById(id).get());
    }

}
