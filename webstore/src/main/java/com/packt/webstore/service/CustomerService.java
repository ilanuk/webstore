package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domainold.Customer;

public interface CustomerService {
	List <Customer> getAllCustomers();
	Customer getCustomerById(String customerID);
}
