package com.lcl.demo.sbDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbDemoApplication.class, args);
	}
}
