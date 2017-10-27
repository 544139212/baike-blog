package com.smx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BaikeBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaikeBlogApplication.class, args);
	}
}
