package com.cts.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.entity.BankAccount;
import com.cts.entity.Customer;
import com.cts.entity.MutualFund;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "The customer Bank Management", description = "Rest controller for BMS")
public class BmsController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(BmsController.class);
	
	@HystrixCommand(fallbackMethod = "getFallBackCustomer")
	@ApiOperation(value = "Get a customer", produces = "customer by username", notes = "Hit this URL to get customer by username")
	@GetMapping(value="/getCustomer/{userName}", produces="application/json")
	public ResponseEntity<String> getCustomerByUserName(@PathVariable("userName") String userName){
		final String Url = "http://localhost:9191/customer/getCustomer/{userName}";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> customer = restTemplate.getForEntity(Url, String.class, userName);
		return customer;
	}
	
	public ResponseEntity<String> getFallBackCustomer(@PathVariable("userName") String userName){
		return (new ResponseEntity<String>("Something went wrong you are seeing this as fallback",HttpStatus.OK));
	}
	
	@HystrixCommand(fallbackMethod = "getFallBackAccount")
	@ApiOperation(value = "Get a account", produces = "account by username", notes = "Hit this URL to get account by username")
	@GetMapping("/getAccount/{userName}")
	public ResponseEntity<String> getAccountByUserName(@PathVariable("userName") String userName){
		final String Url = "http://localhost:9191/account/getAccount/{userName}";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> account = restTemplate.getForEntity(Url, String.class, userName);
		return account;
	}
	
	public ResponseEntity<String> getFallBackAccount(@PathVariable("userName") String userName){
		return (new ResponseEntity<String>("Something went wrong you are seeing this as fallback",HttpStatus.OK));
	}
	
	@HystrixCommand(fallbackMethod = "getFallBackFund")
	@ApiOperation(value = "Get a fund", produces = "fund by username", notes = "Hit this URL to get fund by username")
	@GetMapping("/getFund/{userName}")
	public ResponseEntity<String> getFundByUserName(@PathVariable("userName") String userName){
		final String Url = "http://localhost:9191/fund/getFund/{userName}";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> fund = restTemplate.getForEntity(Url, String.class, userName);
		return fund;
	}
	
	
	public ResponseEntity<String> getFallBackFund(@PathVariable("userName") String userName){
		return (new ResponseEntity<String>("Something went wrong you are seeing this as fallback",HttpStatus.OK));
	}
	
}