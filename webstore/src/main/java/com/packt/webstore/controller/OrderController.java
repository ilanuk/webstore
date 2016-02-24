package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/{myProductId}/{myUnitsInOrder}")
	public String process(@PathVariable("myProductId") String productId, @PathVariable("myUnitsInOrder") String unitsInOrder) {
		orderService.processOrder(productId, Integer.parseInt(unitsInOrder));
		return "redirect:/products";
	}

}
