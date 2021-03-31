package com.ibm.demo.service;


import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ibm.demo.entity.Order;
import com.ibm.demo.repo.OrderRepository;

@Service // Bean
public class OrderService { // Spring Beans
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	RestTemplate getTaxesTemplate;
	@Transactional
	public String createOrder(Order order) {
		//call getTax
		Float tax = getTaxesTemplate.getForObject("http://localhost:8080/getTaxes?price={price}", Float.class,order.getPrice());
		System.out.println(tax);
		order.setTax(tax);
		Order savedOrder = orderRepository.save(order);
		
		/**
		 * Explains hoe the transactional rollback happens
		 */
//		if(order != null) {
//			throw new RuntimeException();
//		}
		return savedOrder.getId();
	}

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public void updateOrder(Order order) {
		orderRepository.save(order);
	}

	public void deleteOrder(String orderId) {
		orderRepository.deleteById(orderId);;
	}

	public Optional<Order> getOrder(String orderId) {
		return orderRepository.findById(orderId);
	}
	
	

}
