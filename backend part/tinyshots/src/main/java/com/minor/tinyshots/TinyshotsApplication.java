package com.minor.tinyshots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TinyshotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyshotsApplication.class, args);
	}

}
