package com.cts.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.bank.entity.BankAccount;

@Repository
public interface BankRepository extends JpaRepository<BankAccount,Integer> {

	@Query(value="Select * from account where user_Name=:userName",nativeQuery=true)
	List<BankAccount> findAccountByUserName(@Param("userName") String userName);

}
