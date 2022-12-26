package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service //Will make it a spring bin component/service.
public class StudentService {

    private final  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //GET
    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }

    //POST
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        //if email already exists, throw an error.
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email already taken, please use a different email.");
        }
        //else
        studentRepository.save(student);

    }
}
