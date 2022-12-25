package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


	//http://localhost:8080/hello-list
	@GetMapping("/hello-list")
	public List<String> helloList(){
		return  List.of("Martin", "Wainaina");
	}
}
