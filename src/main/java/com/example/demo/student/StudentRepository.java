package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //for data access layer
public interface StudentRepository
        extends JpaRepository<Student, Long> {// Long is id type

    //find student by email, method 1
    /**
     *
     * @param email
     * @return
     *
     * This is the same as: SELECT * FROM STUDENT WHERE email = ?
     *
     * The "@Query(...)" can also be commented out/ignored.
     */
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
