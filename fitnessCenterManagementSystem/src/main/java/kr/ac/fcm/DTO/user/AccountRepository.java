package kr.ac.fcm.DTO.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.mapper.AccountMapper;

import lombok.Getter;

@Repository
@Getter
public class AccountRepository {
	
	@Autowired
	AccountMapper accountMapper;
	
	public Account saveAccount(Account account){
		return account;
	}
	
	public Account save(Account account,String role){
		accountMapper.insertUser(account);
		accountMapper.insertUserAutority(account.getId(), role);
		return account;
	}

	public Account findById(String username) {
		// TODO Auto-generated method stub
		return accountMapper.readAccount(username);
	}
	
	public List<String> findAuthoritiesByID(String username){
		return accountMapper.readAutorities(username);
	}
}
