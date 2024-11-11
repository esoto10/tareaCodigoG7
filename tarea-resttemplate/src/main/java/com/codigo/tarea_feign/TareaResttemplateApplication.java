package com.codigo.tarea_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TareaResttemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareaResttemplateApplication.class, args);
	}

}
