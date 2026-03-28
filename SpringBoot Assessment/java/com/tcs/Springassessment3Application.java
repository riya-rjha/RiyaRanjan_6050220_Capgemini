package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tcs", "controller", "service", "repository", "entity", "exceptions"})

public class Springassessment3Application {

	public static void main(String[] args) {
		SpringApplication.run(Springassessment3Application.class, args);
	}

}
