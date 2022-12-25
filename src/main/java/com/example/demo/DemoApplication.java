package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//http://localhost:8080/hello
	@GetMapping("/hello")
	public String hello(){
		return  "Hello world";
	}


	//http://localhost:8080/students-list
	@GetMapping("/students-list")
	public List<Student> helloList(){
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
