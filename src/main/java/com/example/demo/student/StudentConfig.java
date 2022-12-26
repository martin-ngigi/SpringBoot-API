package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.NOVEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

            Student martin = new Student(
                    "Martin",
                    "martinwainaina001@gmail.com",
                    LocalDate.of(1999, NOVEMBER, 23),
                    23
            );

            Student ken = new Student(
                    "Ken",
                    "ken@gmail.com",
                    LocalDate.of(2003, NOVEMBER, 07),
                    23
            );

            repository.saveAll(
                    List.of(martin, ken)
            );
        };
    }
}
