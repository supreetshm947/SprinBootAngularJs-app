package com.example.fullstackangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class FullStackAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackAngularApplication.class, args);
	}
}
