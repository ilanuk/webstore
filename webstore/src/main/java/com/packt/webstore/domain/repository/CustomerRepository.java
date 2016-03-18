package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domainold.Customer;

public interface CustomerRepository {

	List <Customer> getAllCustomers();
	Customer getCustomerById(String customerID);
}
