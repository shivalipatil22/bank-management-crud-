package com.bank.account.ServiceImp;



import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bank.account.Model.Account;
import com.bank.account.Repository.AccountRepo;
import com.bank.account.Service.AccountService;

@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	AccountRepo accRepo;
	
	@Override
	public Account saveAcc(Account account) {
		Account acc = accRepo.save(account);
		return acc;
	}

	@Override
	public Account getAcc(int id) throws AccountNotFoundException {
	 //Account acc1 = accRepo.findById(id).get();
		return accRepo.findById(id).orElseThrow(() -> new AccountNotFoundException ("Account is not found"));
	}

	@Override
	public void deleteAcc(int id) {
		this.accRepo.deleteById(id);
		
	}

	@Override
	public Account updateAcc(Account account) {
		Account acc3 = accRepo.save(account);
		return acc3;
	}

	@Override
	public String findNameandEmail(int id) {
		String name =accRepo.findBynameandemail(id);
		String upperCase = name.toUpperCase();
		return upperCase;
	}

	@Override
	public String findNamee(int id) {
		String name = accRepo.findNamee(id);
		String lowerCase = name.toLowerCase();
		return lowerCase;
	}

	@Override
	public List<Account> findAll() {
		PageRequest page = PageRequest.of(0, 2);
		Page<Account> pageble = accRepo.findAll(page);
		
		List<Account> acc = pageble.getContent();
		return acc;
	}

}
