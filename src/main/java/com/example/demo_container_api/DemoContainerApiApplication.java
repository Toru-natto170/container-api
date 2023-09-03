package com.example.demo_container_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "docker-container-api-sample",  // (1)
		description = "Docker Container サンプル用",  // (2)
		version = "v1"))
public class DemoContainerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoContainerApiApplication.class, args);
	}

}
