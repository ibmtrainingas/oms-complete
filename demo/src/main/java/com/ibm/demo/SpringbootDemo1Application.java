package com.ibm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableTransactionManagement
public class SpringbootDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo1Application.class, args); //Creates the Spring Container
	}
	
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
//	@Bean
//	public MongoTransactionManager transactionManager( ) {
//		return new MongoTransactionManager();
//	}
}
