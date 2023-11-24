package com.ms.rating.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingServiceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceMsApplication.class, args);
	}

}
