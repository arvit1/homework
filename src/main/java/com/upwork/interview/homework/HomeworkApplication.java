package com.upwork.interview.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan("com.upwork.interview.homework.model")
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

}
