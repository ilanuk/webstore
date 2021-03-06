package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.domain.Customer;
import com.packt.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(String customerID) {
		return customerRepository.getCustomerById(customerID);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.saveCustomer(customer);
		
	}

	@Override
	public Customer getCustomer(String customerId) {
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public Boolean isCustomerExist(String customerId) {
		return customerRepository.isCustomerExist(customerId);
	}


}
