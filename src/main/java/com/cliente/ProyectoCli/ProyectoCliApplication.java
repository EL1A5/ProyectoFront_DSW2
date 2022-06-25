package com.cliente.ProyectoCli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cliente"})
public class ProyectoCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCliApplication.class, args);
	}

}
