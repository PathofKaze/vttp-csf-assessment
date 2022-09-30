package vttp2022.assessment.csf.orderbackend.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.assessment.csf.orderbackend.models.Order;
import vttp2022.assessment.csf.orderbackend.models.OrderSummary;
import vttp2022.assessment.csf.orderbackend.repositories.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private PricingService priceSvc;

	public void createOrder(Order order) {

	}
	@Autowired
    private OrderRepo orderRepo;

	public Optional<Order> createOrder(String payload) {
		return orderRepo.createOrder(payload);
	 }

	public List<OrderSummary> getOrdersByEmail(String email) {
	
			return orderRepo.getOrdersByEmail(email);
	}
}
