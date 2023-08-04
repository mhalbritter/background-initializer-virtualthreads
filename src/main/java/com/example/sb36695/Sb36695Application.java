package com.example.sb36695;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb36695Application {

	public static void main(String[] args) {
		Timing.INSTANCE.setStarted(System.nanoTime());
		SpringApplication.run(Sb36695Application.class, args);
	}

}
