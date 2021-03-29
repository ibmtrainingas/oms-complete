package com.ibm.demo;



import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.service.OrderService;


@RestController
public class UserController {
	Logger logger = Logger.getLogger(UserController.class.getName());
	@GetMapping("/hello")
	String hello() {
		logger.setLevel(Level.WARNING);
		//logger.log(Level.WARNING,OrderService.hashCode() + " printed");
		return "Hello";
	}

}
