package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Customer;
import com.cts.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
		
	public List<Customer> getCustomerByUserName(String userName) {
		return (List<Customer>) customerRepository.getByCustomerUserName(userName);
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}

	public void deleteCustomer(String userName) {
		customerRepository.deleteCustomer(userName);
		
	}

	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}
	
}


