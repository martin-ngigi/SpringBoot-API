package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service //Will make it a spring bin component/service.
public class StudentService {
    public List<Student> getStudents(){
        return  List.of(
                new Student(
                        1L,
                        "Martin",
                        "martinwainaina001@gmail.com",
                        LocalDate.of(1999, Month.NOVEMBER, 23),
                        23
                )
        );
    }
}
