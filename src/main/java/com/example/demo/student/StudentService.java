package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service //Will make it a spring bin component/service.
public class StudentService {

    private final  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
//        return  List.of(
//                new Student(
//                        1L,
//                        "Martin",
//                        "martinwainaina001@gmail.com",
//                        LocalDate.of(1999, Month.NOVEMBER, 23),
//                        23
//                )
//        );
        return  studentRepository.findAll();
    }
}
