package com.example.springscheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class SpringSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulerApplication.class, args);
	}

}
