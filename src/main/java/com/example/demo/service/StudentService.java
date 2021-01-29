package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
@Slf4j

public class StudentService {
    final StudentRepository studentRepository;

    @Cacheable(value = "student", key = "#id")
    public Student getStudentByID(int id)  {
        Student student=studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Students","id",id));
        try {
            log.info("The system is paused for 3 sec");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return studentRepository.findById(id).get();
    }

    @Cacheable(value = "students")
    public Page<Student> getAllStudents(Pageable pageable) {

        try {
            log.info("The system is paused for 3 sec");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        Page<Student> students = studentRepository.findAll(pageable);
        return students;

     /*   return new GenericPagedDto(students
                .stream()
                .collect(Collectors.toList()), pageable, students.getTotalElements());

      */
    }


    public Student addStudent(Student student) {
        if(studentRepository.existsById(student.getId()))throw new ResponseStatusException(HttpStatus.CONFLICT, "Student already exist");
        try {
            log.info("The system is paused for 3 sec");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return studentRepository.save(student);
    }

    @CachePut(value = "student", key = "#id")
    @CacheEvict(value = "students", allEntries = true)
    public Student updateStudent(int id, Student student) {

        studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Students","id",id));
        try {
            log.info("The system is paused for 3 sec");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        var exStudent = studentRepository.findById(id).get();
        exStudent.setName(student.getName());
        exStudent.setSurname(student.getSurname());
        studentRepository.save(exStudent);
        return exStudent;
    }

    @Caching(evict = {
            @CacheEvict(value = "student", key = "#id"),
            @CacheEvict(value = "students", allEntries = true)
    })
    public void deleteStudent(int id) {
        Student student=studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Students","id",id));
        studentRepository.delete(studentRepository.findById(id).get());
    }

}
