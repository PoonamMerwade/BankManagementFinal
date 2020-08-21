//package com.cts.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cts.entity.Customer;
////import com.cts.service.CustomerServiceImpl;
//import com.cts.repository.CustomerRepository;
//
//import io.swagger.annotations.Api;
//
//@RestController
//@RequestMapping("/secure/auth")
//@Api(value = "The customer Bank Management", description = "Rest controller for BMS")
//public class BmsController {
//	
//	@GetMapping("/process")
//	public String process() {
//		return "processing..";
//	}
//	@Autowired
//	private CustomerRepository userRepository;
//
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	/*@PreAuthorize("hasAnyRole('ADMIN')")*/
//	@PreAuthorize("hasAnyRole('USER')")
//	@PostMapping("/admin/add")
//	public String addUserByAdmin(@RequestBody Customer user) {
//		String pwd = user.getPassword();
//		String encryptPwd = passwordEncoder.encode(pwd);
//		user.setPassword(encryptPwd);
//		userRepository.save(user);
//		return "user added successfully...";
//	}
//
//	
////	@Autowired
////    private RestTemplate restTemplate;
////	
////	@Autowired 
////	CustomerServiceImpl customerService;
////	
////	Logger logger = LoggerFactory.getLogger(BmsController.class);
////	
////	@RequestMapping({ "/greeting" })
////    public String welcomePage() {
////        return "Welcome!";
////    }
////    
////	@PostMapping(value = "/sign-up", produces = "application/json")
////	public Customer createUser(@Valid @RequestBody Customer customer) {
////		Customer details =  customerService.createCustomer(customer);
////		if(details.getUserName().isEmpty()) {
////			logger.info("Response Successfully Executed");
////			
////		}
////		else {
////			throw new RuntimeException("User with same pan No already exist!!");
////		}
////
////		return details;
////
////	}
////	
////	@ApiOperation(value = "Get a customer", produces = "customer by username", notes = "Hit this URL to get customer by username")
////	@GetMapping(value="/getCustomer/{userName}", produces="application/json")
////	public String getCustomerByUserName(@PathVariable("userName") String userName){
////		final String Url = "http://localhost:9191/customer/getCustomer/{userName}";
////		RestTemplate restTemplate = new RestTemplate();
////		String customer = restTemplate.getForObject(Url, String.class, userName);
////		return customer;
////	}
////	
////	@ApiOperation(value = "Get a account", produces = "account by username", notes = "Hit this URL to get account by username")
////	@GetMapping("/getAccount/{userName}")
////	public String getAccountByUserName(@PathVariable("userName") String userName){
////		final String Url = "http://localhost:9191/account/getAccount/{userName}";
////		RestTemplate restTemplate = new RestTemplate();
////		String account = restTemplate.getForObject(Url, String.class, userName);
////		return account;
////	}
////	
////	@ApiOperation(value = "Get a fund", produces = "fund by username", notes = "Hit this URL to get fund by username")
////	@GetMapping("/getFund/{userName}")
////	public String getFundByUserName(@PathVariable("userName") String userName){
////		final String Url = "http://localhost:9191/fund/getFund/{userName}";
////		RestTemplate restTemplate = new RestTemplate();
////		String fund = restTemplate.getForObject(Url, String.class, userName);
////		return fund;
////	}
////	
//
//
//}