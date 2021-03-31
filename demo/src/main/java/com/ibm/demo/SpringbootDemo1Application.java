package com.ibm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo1Application.class, args); //Creates the Spring Container
	}
	
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	PlatformTransactionManager transactionManager() {
		return new MongoTransactionManager();
	}

}
