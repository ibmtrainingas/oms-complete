package com.ibm.searchorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.searchorder.entity.Order;
import com.ibm.searchorder.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	/**
	 * method to get all the orders at one go
	 * 
	 * @return
	 */

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	/**
	 * Return the method to search order by its order Id
	 * 
	 * @param orderId
	 * @return
	 */

	public Optional<Order> getOrder(String orderId) {
		return orderRepository.findById(orderId);
	}

}
