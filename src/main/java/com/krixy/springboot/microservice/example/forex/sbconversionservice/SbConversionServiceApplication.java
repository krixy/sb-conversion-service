package com.krixy.springboot.microservice.example.forex.sbconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.krixy.springboot.microservice.example.forex.sbconversionservice.proxy")
public class SbConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbConversionServiceApplication.class, args);
	}

}
