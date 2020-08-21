package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Customer;
import com.cts.entity.MutualFund;
import com.cts.repository.FundRepository;

@Service
public class FundService {

	@Autowired
	FundRepository fundRepository;
	
	public void addFund(MutualFund fund) {
		fundRepository.save(fund);
		
	}
	public List<MutualFund> getFundDetailsByUserName(String userName) {
		return (List<MutualFund>)fundRepository.findByUserName(userName);
	}

}
