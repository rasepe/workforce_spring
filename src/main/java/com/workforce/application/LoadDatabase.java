package com.workforce.application;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

//	private Object log;

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "assistant")));
			log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "manager")));
		};
	}
}