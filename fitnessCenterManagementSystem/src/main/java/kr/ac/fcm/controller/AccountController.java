package kr.ac.fcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.fcm.mapper.AccountMapper;
import kr.ac.fcm.service.AccountService;
import kr.ac.fcm.user.Account;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@Autowired
	AccountMapper accountMapper;
	
	
	//ADMIN 계정 부여
	@GetMapping("/create")
	public Account create(){
		Account account=new Account();
		account.setId("admin");
		account.setPassword("1234");
		accountService.save(account, "ROLE_ADMIN", "ADMIN");
		return account;
	}


}
