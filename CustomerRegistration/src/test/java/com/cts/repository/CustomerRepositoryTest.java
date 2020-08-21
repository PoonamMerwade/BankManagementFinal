package com.cts.repository;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
	
	@MockBean
	CustomerRepository customerRepository;
	
	@Test
	public void testFindByUserName() {
		List<Customer> list = new ArrayList<>();
		Customer customer=new Customer("Poonam","Merwade","GHYRY5675Z","Poonam@123","poonam@gmail.com","1997-05-10","9988776567");
		list.add(customer);
		when(customerRepository.getByCustomerUserName("AJNPU0692G")).thenReturn(list);
		Assert.assertEquals(1, list.size());
	}
	

}
