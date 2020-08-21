package com.cts.entity;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

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
//	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "name can only have alphabets with minimum length 2")
//	@NotNull(message = "Name cannot be null")
	private String firstName;
	
//	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "name can only have alphabets with minimum length 2")
	@ApiModelProperty(value = "last name of the customer")
	private String lastName;
	
	@Id
//	@NotNull(message = "PAN cannot be null")
//	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "name can only have alphabets with length 10")
//	@ApiModelProperty(value = "PAN of the customer")
	private String userName;
	
//	@NotNull(message = "Password cannot be null")
//	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$",message="password should be valid")
//	@Size(min = 8, message = "password must have atleast 8 characters")
	@ApiModelProperty(value = "password of the customer")
	private String password;
	
	@Email
	@ApiModelProperty(value = "Email Id of the customer")
	private String emailId;
	
//	@NotNull(message = "DOB cannot be null")
//	@Pattern(regexp ="/([12]/d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]/d|3[01]))/",message="enter valid DOB")
	@ApiModelProperty(value = "DOB of the customer")
	private String dob;
	
//	@NotNull(message = "phone cannot be null")
//	@Pattern(regexp ="[1-9]{1}[0-9]{9}", message = "mobile number must be of 10 digits and should not begin with 0")
	@ApiModelProperty(value = "Phone of the customer")
	private String phoneNumber;
	
//	@Transient
	@OneToMany
	private List<BankAccount> bankAccount;
	
//	@Transient
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

	

	public Customer(int i, String string, String string2, String string3, String string4, int j, int k,
			HashSet<BankAccount> hashSet) {
		// TODO Auto-generated constructor stub
	}

	
}
