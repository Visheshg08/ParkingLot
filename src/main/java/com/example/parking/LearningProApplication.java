package com.example.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LearningProApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningProApplication.class, args);
	}

}
