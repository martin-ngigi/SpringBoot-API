package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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
            throw new IllegalStateException("Error: Email already taken, please use a different email.");
        }
        //else
        studentRepository.save(student);

    }

    //DELETE
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        //if student doesnt exists
        if (!exists){
            throw new IllegalStateException("Error: Student with id "+studentId+" does not exist.");
        }
        //else
        studentRepository.deleteById(studentId);
    }

    /**
     *eg:
     * http://localhost:8080/api/v1/students/update-student/2?email=ken1@gmail.com
     * http://localhost:8080/api/v1/students/update-student/2?name=ken
     */
    @Transactional//goes to a managed state
    public void updateStudent(Long studentId, String name, String email) {
       //check if user exists
        Student student = studentRepository.findById(studentId)
               .orElseThrow(() -> new IllegalStateException("Error: Student with id "+studentId+" does not exist."));

       if (name !=null &&
               name.length()>0 //check length of the name
               &&
               !Objects.equals(student.getName(), name) //check if name is similar to existing name
       ){
           student.setName(name);
       }

        if (email !=null &&
                email.length()>0 //check length of the email is greater than 0
                &&
                !Objects.equals(student.getEmail(), email) //check if email is similar to existing email
        ){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            //check whether email has already been taken
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Error: Email already taken, please use a different email.");
            }

            student.setEmail(email);
        }
    }

    public void updateStudent2(Long studentId, Student student) {
        //get data from request
        String name = student.getName();
        String email = student.getEmail();

        //check if user exists
        Student studentFromDB = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Error: Student with id "+studentId+" does not exist."));
        if (name !=null &&
                name.length()>0 //check length of the name
                &&
                !Objects.equals(studentFromDB.getName(), name) //check if name is not similar to existing name
        ){
            studentFromDB.setName(name);
        }

        if (email !=null &&
                email.length()>0 //check length of the email is greater than 0
                &&
                !Objects.equals(studentFromDB.getEmail(), email) //check if email is not similar to existing email
        ){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            //check whether email has already been taken
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Error: Email already taken, please use a different email.");
            }

            studentFromDB.setEmail(email);
        }
        studentRepository.save(studentFromDB);



        //ABOVE METHOD IS SIMILAR TO ONE BELOW, ONLY THAT THE ONE BELOW DOES NOT DO VALIDATIONS
        /**
        Student student_from_db = studentRepository.findById(studentId).get();
        student_from_db.setName(student.getName());
        student_from_db.setEmail(student.getEmail());
        studentRepository.save(student_from_db);
         **/


    }
}
