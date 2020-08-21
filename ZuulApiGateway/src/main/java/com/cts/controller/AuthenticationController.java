//package com.cts.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cts.configuration.JwtTokenUtil;
//import com.cts.model.ApiResponse;
//import com.cts.model.User;
//import com.cts.service.CustomerServiceImpl;
//
//
//@RestController
//@CrossOrigin
//public class AuthenticationController {
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
////	@Autowired
//	private CustomerServiceImpl jwtUserDetailsService;
//	
//
//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {
//
//		authenticate(authenticationRequest.getUsername().toUpperCase(), authenticationRequest.getPassword());
//
//		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//		final String token = jwtTokenUtil.generateToken(userDetails);
//
//		return ResponseEntity.ok(new ApiResponse(token));
//	}
//
//	
//	private void authenticate(String username, String password) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
//}
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.ComponentScan;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.AuthenticationException;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestMethod;
////import org.springframework.web.bind.annotation.RestController;
////
////import com.cts.configuration.JwtTokenUtil;
////import com.cts.entity.Customer;
////import com.cts.model.ApiResponse;
////import com.cts.model.AuthToken;
////import com.cts.service.CustomerServiceImpl;
////
////
////@RestController
////@RequestMapping("/user")
////public class AuthenticationController {
////	@Autowired
////	private AuthenticationManager authenticationManager;
////
////	@Autowired
////	private JwtTokenUtil jwtTokenUtil;
////	
//////	@Autowired
//////	private Customer customer;
////	
////	@Autowired
////	private Customer customer;
////	
////	@Autowired
////	private CustomerServiceImpl customerService;
////	
////	@RequestMapping(value = "/login", method = RequestMethod.POST)
////	public ApiResponse<AuthToken> register(@RequestBody Customer customer) throws AuthenticationException {
////
////		authenticationManager
////				.authenticate(new UsernamePasswordAuthenticationToken(customer.getUserName(), customer.getPassword()));
////		final Customer authenticateCustomer = customerService.findCustomerByUserName(customer.getUserName());
////		final String token = jwtTokenUtil.dogenerateToken(authenticateCustomer);
////		System.out.println("user successfully login");
////		return new ApiResponse<>(200, "success",
////				new AuthToken(token, customer.getUserName(), authenticateCustomer.getUserName()));
////
////	}
////}
