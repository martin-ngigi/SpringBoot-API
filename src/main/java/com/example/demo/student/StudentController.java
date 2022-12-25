package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final  StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //http://localhost:8080/api/v1/students/hello
    @GetMapping("/hello")
    public String hello(){
        return  "Hello world";
    }

    //http://localhost:8080/api/v1/students/students-list
    @GetMapping("/students-list")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
