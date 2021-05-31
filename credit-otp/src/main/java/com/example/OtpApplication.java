package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpApplication.class, args);
		System.out.println("the Ioc container was loaded");

	}
}
