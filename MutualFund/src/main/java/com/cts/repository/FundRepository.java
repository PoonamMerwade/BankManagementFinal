package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.entity.Customer;
import com.cts.entity.MutualFund;

@Repository
public interface FundRepository extends JpaRepository<MutualFund,Integer> {

	@Query(value="Select * from fund where user_Name=:userName",nativeQuery=true)
	List<MutualFund> findByUserName(@Param("userName") String userName);

}
