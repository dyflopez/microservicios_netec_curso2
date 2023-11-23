package com.ms.hotel.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMsApplication.class, args);
	}

}
