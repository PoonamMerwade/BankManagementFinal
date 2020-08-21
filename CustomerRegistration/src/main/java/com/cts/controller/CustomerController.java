package com.cts.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.cts.entity.BankAccount;
//import com.cts.bank.entity.BankAccount;
import com.cts.entity.Customer;
import com.cts.entity.MutualFund;
import com.cts.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "The customer Controller", description = "Rest controller for customer")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
		
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@ApiOperation(value = "Get a customer", produces = "customer by username", notes = "Hit this URL to get customer by username")
	@GetMapping("/getCustomer/{userName}")
	public List<Customer> getCustomerByUserName(@PathVariable String userName){
		logger.debug("Request: {} ", userName);
		List<Customer> list = customerService.getCustomerByUserName(userName);
		if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution !");
        } else {
            logger.info("Response: Successfully Executed");
        }

        return list;
	}
	@ApiOperation(value = "Add a customer", consumes = "A new customer is JSON", notes = "Hit this URL to insert a new customer's details")
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public void addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
	}
				
	@ApiOperation(value = "Delete customer", consumes = "An existing username", notes = "Hit this URL to delete a customer's details")
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{userName}")
	void deleteCustomerByUserName(@PathVariable String userName){
		customerService.deleteCustomer(userName);
	}
	
	@ApiOperation(value = "Update a customer's details", consumes = "An existing customer in JSON", notes = "Hit this URL to update a customer's details")
	@RequestMapping(method=RequestMethod.PUT,value="/update")
	void updateCustomerByUserName(@RequestBody Customer customer){
		customerService.updateCustomer(customer);
	}	

	
}
