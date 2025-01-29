package com.fouad.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fouad.Bank.repository")
@EntityScan("com.fouad.Bank.model")
public class Bank1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bank1Application.class, args);
	}

}
