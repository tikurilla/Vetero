package com.vetero.veteroserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VeteroServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(VeteroServerApplication.class, args);
	}
}
