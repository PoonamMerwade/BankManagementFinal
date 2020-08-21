package com.cts.entity;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cts.entity.Customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity(name="fund")
public class MutualFund {
	@Id
	@ApiModelProperty(value = "Id of the mutual fund")
	private int fundId;
	
	@ApiModelProperty(value="Name of the fund")
	private String fundName;
	
	@ApiModelProperty(value="Transaction amount")
	private long transactionAmount;
	
	@ApiModelProperty(value="Account number of the customer")
	private String accountNumber;
	
	@ApiModelProperty(value="Investment of the customer")
	private long investmentAmout;
	
	@ManyToOne
	@JoinColumn(name="userName")
	private Customer customer;

	public MutualFund(int fundId, String fundName, long transactionAmount, String accountNumber, long investmentAmout,
			Customer customer) {
		super();
		this.fundId = fundId;
		this.fundName = fundName;
		this.transactionAmount = transactionAmount;
		this.accountNumber = accountNumber;
		this.investmentAmout = investmentAmout;
		this.customer = customer;
	}

	public MutualFund(int i, String string, String string2, String string3, String string4, int j, int k,
			HashSet<BankAccount> hashSet) {
		// TODO Auto-generated constructor stub
	}	
}
