package com.cts.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.entity.Customer;
import com.cts.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceTesting {
	
	@Mock
	private CustomerRepository repo;
	
	@InjectMocks
	private CustomerService service;
		
	@Test
	public void testAddUser() {
	      Customer customer=new Customer("Poonam","Merwade","GHYRY5675Z","Poonam@123","poonam@gmail.com","1997-05-10","9988776567");
	      service.addCustomer(customer);
	      verify(repo, times(1)).save(customer);

	}
	
	@Test
	public void testGetCustomerByUserName() {
		List<Customer> list=new ArrayList<>(); 
		Customer customer= new Customer("Poonam","Merwade","GHYRY5675Z","Poonam@123","poonam@gmail.com","1997-05-10","9988776567");
		list.add(customer);
		Mockito.when(repo.getByCustomerUserName("AJNPU0692G")).thenReturn(list);
		List<Customer> customerList = service.getCustomerByUserName("AJNPU0692G");
		assertEquals(1, customerList.size());
		
//		assertSame("AJNPU0692G", service.getCustomerByUserName("AJNPU0692G"));
	}
	
}
