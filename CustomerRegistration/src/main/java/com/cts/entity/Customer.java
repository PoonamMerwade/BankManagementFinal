package com.cts.entity;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@ApiModel(description = "This is the customer model")
@Entity(name="customer")
public class Customer {
	
	@ApiModelProperty(value = "first name of the customer")
	private String firstName;
	
	@ApiModelProperty(value = "last name of the customer")
	private String lastName;
	
	@Id
	@ApiModelProperty(value = "PAN of the customer")
	private String userName;
	
	@ApiModelProperty(value = "password of the customer")
	private String password;
	
	@Email
	@ApiModelProperty(value = "Email Id of the customer")
	private String emailId;
	
	@ApiModelProperty(value = "DOB of the customer")
	private String dob;
	
	@ApiModelProperty(value = "Phone of the customer")
	private String phoneNumber;
	
	@OneToMany
	private List<BankAccount> bankAccount;
	
	@OneToMany
	private List<MutualFund> mutualFund;

	public Customer(String firstName, String lastName, String userName, String password, String emailId, String dob,
			String phoneNumber, List<BankAccount> bankAccount, List<MutualFund> mutualFund) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.bankAccount = bankAccount;
		this.mutualFund = mutualFund;
	}

	

	public Customer(String string5, String string, String string2, String string3, String string4, String string6, int k,
			HashSet<Customer> hashSet) {
		// TODO Auto-generated constructor stub
	}



	public Customer(String string, String string2, String string3, String string4, String string5, String string6,
			String string7) {
		// TODO Auto-generated constructor stub
	}



	public Customer(int i, String string, String string2, int j) {
		// TODO Auto-generated constructor stub
	}

	
}
