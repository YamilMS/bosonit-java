package com.bosonit.demo;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Block5CommandLineRunnerApplication.class);
	private final ConfigProfiles configProfile;

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application"); // Configura el nombre del archivo de configuración
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
		LOGGER.error("Esto es un mensaje de error"); // Log de nivel "ERROR"
		LOGGER.warn("Esto es un mensaje de advertencia"); // Log de nivel "WARNING"
		LOGGER.info("Esto es un mensaje informativo"); // Log de nivel "INFO"
		LOGGER.debug("DEBUG");
		LOGGER.trace("TRACE");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("name: {}", configProfile.getName());
		log.info("url: {}", configProfile.getUrl());
	}
}

