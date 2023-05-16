package com.bosonit.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class Block5CommandLineRunnerApplication{

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application"); // Configura el nombre del archivo de configuración
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args
		);
	}

}

