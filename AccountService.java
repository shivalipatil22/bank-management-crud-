package com.bank.account.Service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.bank.account.Model.Account;

public interface AccountService {

	//post add method
	public Account saveAcc(Account acount);
	
	//Get
	public Account getAcc(int id) throws AccountNotFoundException;
	
	public void  deleteAcc(int id);
	
	public Account updateAcc(Account account);
	
	public String findNameandEmail(int id);
	
	public String findNamee(int id);
	
	public List<Account> findAll();
	
}
