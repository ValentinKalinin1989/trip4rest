package com.senla.tripstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TripStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripStorageApplication.class, args);
	}

}
