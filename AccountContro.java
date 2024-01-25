package com.bank.account.Controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.Model.Account;
import com.bank.account.Service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountContro {

	@Autowired
	AccountService accSer;
	
	@PostMapping("save")
	public Account saveAcc(@Valid @RequestBody Account acc)
	{
		return accSer.saveAcc(acc);
	}
	
	@GetMapping("get/{id}")
	public Account getAcc(@PathVariable ("id")int id) throws AccountNotFoundException
	{
		return accSer.getAcc(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteAcc(@PathVariable("id")int id)
	{
		this.accSer.deleteAcc(id);
	}
	
	@PutMapping("update")
	public Account updateAcc(@RequestBody Account acc)
	{
		return accSer.updateAcc(acc);
	}
	
	@GetMapping("gets/{id}")
	public String findNameandEmail(@PathVariable("id")int id)
	{
		return accSer.findNameandEmail(id);
	}
	@GetMapping("getss/{id}")
	public String findNamee(@PathVariable("id")int id)
	{
		return accSer.findNamee(id);
	}
	
	@GetMapping("findAll")
	public List<Account> findAll()
	{
		return accSer.findAll();
	}
}
