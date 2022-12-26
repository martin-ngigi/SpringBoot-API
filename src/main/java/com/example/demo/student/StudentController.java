package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final  StudentService studentService;

    @Autowired //for dependency injection. This instantiates the student
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

    //http://localhost:8080/api/v1/students/add-student
    @PostMapping("/add-student")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //http://localhost:8080/api/v1/students/delete-student/1
    @DeleteMapping("/delete-student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

}
