package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.domain.Address;
import com.packt.webstore.domain.Customer;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
		Customer first = new Customer("C001","Robert John");
		addAddress(first,"15500","Bruce B Downs Blvd","Tampa","FL", "USA", "33647","8138001000");
		Customer second = new Customer("C002","Chris Manny");
		addAddress(second,"15501","Bruce B Downs Blvd","Tampa","FL", "USA", "33647","8138002000");
		Customer third = new Customer("C003","Mary Ann");
		addAddress(third,"15502","Bruce B Downs Blvd","Tampa","FL", "USA", "33647","8138003000");
		Customer fourth = new Customer("C004","Glenn Martin");
		addAddress(fourth,"15502","Bruce B Downs Blvd","Tampa","FL", "USA", "33647","8138004000");
		listOfCustomers.add(first);
		listOfCustomers.add(second);
		listOfCustomers.add(third);
		listOfCustomers.add(fourth);
	}

	private void addAddress(Customer first, String doorNo, String streetName, String areaName, String state,
			String country, String zipCode, String phoneNumber) {
		Address add1 = new Address();
		add1.setDoorNo(doorNo);
		add1.setStreetName(streetName);
		add1.setAreaName(areaName);
		add1.setState(state);
		add1.setCountry(country);
		add1.setZipCode(zipCode);
		first.setBillingAddress(add1);
		first.setPhoneNumber(phoneNumber);
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
		if(!this.isCustomerExist(customer.getCustomerId())) {
			listOfCustomers.add(customer);
		}
	}

	@Override
	public Customer getCustomer(String customerId) {
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
	public Boolean isCustomerExist(String customerId) {
		Customer customerById = null;
		for(Customer customer :listOfCustomers) {
		      if(customer!=null && customer.getCustomerId()!=null && customer.getCustomerId().equals(customerId)){
		    	  	customerById = customer;
			        break;
			      }
		}
	    if(customerById == null){
		      return false;
		}
	    return true;
	}

}
