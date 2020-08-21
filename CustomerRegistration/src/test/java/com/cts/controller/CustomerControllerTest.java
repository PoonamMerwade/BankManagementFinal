package com.cts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.cts.entity.Customer;
import com.cts.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;
	
	
	@Test
	public void addVendorTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/add").accept(MediaType.APPLICATION_JSON).content(
				"{\"firstName\":\"Poonam\", "
				+ "\"lastName\": \"merwade\","
				+ " \"userName\": \"ABCDE5676F\", "
				+ "\"password\": \"poonam@34\", "
				+ "\"emailId\": \"poonam@gmail.com\","
				+ "\"dob\":\"1997-10-05\","
				+ "\"phomeNumber\":\"8971769099\"}")
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().is(200)).andReturn();
	}
	
	
	@Test
	public void deleteCustomerTest() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.delete("/delete/{userName}", "GHJIT5643S");
		mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

}
