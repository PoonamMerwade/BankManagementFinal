//package com.cts.service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import com.cts.entity.Customer;
//import com.cts.model.User;
//import com.cts.repository.CustomerRepository;
//
//@Component
//@Service
//public class CustomerServiceImpl implements UserDetailsService {
//	
//	@Autowired
//	private BCryptPasswordEncoder bcryptEncoder;
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	public Customer createCustomer(Customer customer) {
//
//		customerRepository.save(customer);
//
//		customer.setPassword(bcryptEncoder.encode(customer.getPassword()));
//		return customerRepository.save(customer);
//	}
//
//
//	@Override
//	public UserDetails loadUserByUsername(String userName) {
//		User response = customerRepository.getByCustomerUserName(userName);
//		
//		if (response == null) {
//			throw new UsernameNotFoundException("User not found with username: " + userName);
//		}
//		
//		return new org.springframework.security.core.userdetails.User(response.getUsername(), response.getPassword(),
//				new ArrayList<>());
//	}
//
//	
//	private List<SimpleGrantedAuthority> getAuthority() {
//
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//	}
//
//	public Customer findCustomerByUserName(String userName) {
//		return customerRepository.findByUserName(userName);
//	}
//
//}
//
//
////@Override
////public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////
////	Customer customer = customerRepository.getByCustomerUserName(username);
////
////	if (customer == null) {
////		throw new UsernameNotFoundException("Invalid username or password.");
////	}
////	return new org.springframework.security.core.userdetails.User(customer.getUserName(), customer.getPassword(),
////			getAuthority());
////}