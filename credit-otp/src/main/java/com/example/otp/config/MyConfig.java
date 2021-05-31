package com.example.otp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class MyConfig {
	
	@Bean
	RestTemplate restTamplate()
	{
		return new RestTemplate();
	}

}
