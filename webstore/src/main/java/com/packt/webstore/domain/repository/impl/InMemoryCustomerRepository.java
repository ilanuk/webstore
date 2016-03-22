package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.domain.Customer;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
//		Customer first = new Customer("C001","Robert John", "Tampa, FL");
//		first.setNoOfOrdersMade(100);
//		Customer second = new Customer("C002","Chris Manny", "Miami, FL");
//		second.setNoOfOrdersMade(200);
//		Customer third = new Customer("C003","Mary Ann", "Atlanta, GA");
//		third.setNoOfOrdersMade(300);
//		Customer fourth = new Customer("C004","Glenn Martin", "New York, NY");
//		fourth.setNoOfOrdersMade(400);
//		listOfCustomers.add(first);
//		listOfCustomers.add(second);
//		listOfCustomers.add(third);
//		listOfCustomers.add(fourth);
	}

	@Override
	public Customer getCustomerById(String customerId) {
		Customer customerById = null;
		for(Customer customer :listOfCustomers) {
		      if(customer!=null && customer.getCustomerId()!=null && customer.getCustomerId().equals(customerId)){
		    	  	customerById = customer;
			        break;
			      }
		}
	    if(customerById == null){
		      throw new IllegalArgumentException("No customers found with the customer id: "+ customerId);
		    }
		    
		    return customerById;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isCustomerExist(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
