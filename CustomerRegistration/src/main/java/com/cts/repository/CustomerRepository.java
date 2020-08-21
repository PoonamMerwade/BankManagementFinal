package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
	
	@Query(value="delete from customer where user_Name=:userName",nativeQuery=true)
	void deleteCustomer(@Param("userName") String userName );

	@Query(value="Select * from customer where user_Name=:userName",nativeQuery=true)
	List<Customer> getByCustomerUserName(@Param("userName")String userName);
	
}
