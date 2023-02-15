package es.aclavijo.bikeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BikeApplication {
	public static void main(String[] args) {
		SpringApplication.run(BikeApplication.class, args);
	}

}
