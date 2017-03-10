package com.docker.mobystore.service;

import java.util.List;

import com.docker.mobystore.model.Order;
import com.docker.mobystore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order findById(Long orderId) {
		return orderRepository.findOne(orderId) ;
	}

	public void saveOrder(Order order) {
		orderRepository.save(order);
	}

	public void updateOrder(Order order) {
		orderRepository.save(order);
	}

	public void deleteOrderById(Long orderId) {
		orderRepository.delete(orderId);
	}

	public void deleteAllItems() {
		orderRepository.deleteAll();
	}

	public boolean orderExists(Order order) {
		return findById(order.getOrderId()) != null;
	}

	public List<Order> findAllOrders() {
		return (List<Order>) orderRepository.findAll();
	}

	@Override
	public List<Order> findByOrderNum(int orderNum) {
		// TODO Auto-generated method stub
		return (List<Order>) orderRepository.findByOrderNum(orderNum);
	}
	

}
