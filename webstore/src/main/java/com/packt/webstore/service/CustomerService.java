package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Customer;

public interface CustomerService {
	List <Customer> getAllCustomers();
	Customer getCustomerById(String customerID);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(String customerId);

	public Boolean isCustomerExist(String customerId);
}
