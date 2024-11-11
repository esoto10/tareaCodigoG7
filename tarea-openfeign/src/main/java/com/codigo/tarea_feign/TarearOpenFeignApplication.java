package com.codigo.tarea_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TarearOpenFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(TarearOpenFeignApplication.class, args);
	}

}
