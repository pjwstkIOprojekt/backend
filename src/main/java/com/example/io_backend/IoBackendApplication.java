package com.example.io_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IoBackendApplication {

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	};

	public static void main(String[] args) {
		SpringApplication.run(IoBackendApplication.class, args);
	}

}
