package com.cts.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bank.entity.BankAccount;
import com.cts.bank.service.BankService;

import io.swagger.annotations.ApiOperation;
@RestController
//@RequestMapping("/secured")

//@RequestMapping("/account")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	Logger logger = LoggerFactory.getLogger(BankController.class);
		
	@ApiOperation(value = "Get all aacounts", produces = "List of accounts", notes = "Hit this URL to get all accounts")
	@GetMapping("/getAccount/{userName}")
	public List<BankAccount> getAccountByUserName(@PathVariable("userName") String userName ) {
		logger.debug("Resquest: {} ", userName);
		List<BankAccount> list = bankService.getAccountByUserName(userName);
		if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution !");
        } else {
            logger.info("Response: Successfully Executed");
        }

        return list;
	}
	
	
	@ApiOperation(value = "Add a account", consumes = "A new account details", notes = "Hit this URL to insert a new account details")
	@PostMapping("/add")
	public void addAccount(@RequestBody BankAccount account){
		bankService.addAccount(account);
	}
	
	@ApiOperation(value = "Update a account's details", consumes = "An existing account in JSON", notes = "Hit this URL to update a account's details")
	@PutMapping("/update")
	public void updateAccount(@RequestBody BankAccount account){
		bankService.updateAccount(account);
	}
}
