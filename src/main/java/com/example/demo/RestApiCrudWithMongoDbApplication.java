package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.example.demo.controller")
public class RestApiCrudWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiCrudWithMongoDbApplication.class, args);

	}

}
