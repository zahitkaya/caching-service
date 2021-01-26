package com.example.demo.loader;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class StudentLoader {
    final StudentRepository studentRepository;


    @PostConstruct
    public void initiliazeStudents(){

        Student student=Student.builder()
                .id(100)
                .name("Zahit")
                .build();

        Student student1=Student.builder()
                .id(101)
                .name("Mehmet")
                .surname("Taş")
                .build();

        studentRepository.save(student);
        studentRepository.save(student1);


    }
}
