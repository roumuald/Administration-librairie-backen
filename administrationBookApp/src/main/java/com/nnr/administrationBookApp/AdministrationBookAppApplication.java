package com.nnr.administrationBookApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AdministrationBookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministrationBookAppApplication.class, args);
	}

}
