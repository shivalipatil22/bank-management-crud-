package com.bank.account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.account.Model.Account;

public interface AccountRepo extends JpaRepository<Account,Integer>{

	@Query(value = "select name from account where id=:id", nativeQuery = true)
	String findBynameandemail(@Param("id") int id);

	@Query(value = "select name from account where id=:id" , nativeQuery = true)
	String findNamee(@Param("id")int id);

	
	
	

}
