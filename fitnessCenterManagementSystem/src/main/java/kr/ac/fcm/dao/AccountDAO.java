package kr.ac.fcm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.mapper.AccountMapper;

import lombok.Getter;

/*
 * Create Account and Account's Authority - save, saveAutority
 * Read Account and Accounts' Authorities - findById, findAuthoritiesById
 * Revise password
 */
@Repository
@Getter
public class AccountDAO {
	
	@Autowired
	private AccountMapper accountMapper;
	
	public Account save(Account account){
		accountMapper.insertUser(account);
		return account;
	}
	
	public Account saveAutority(Account account, String role){
		accountMapper.insertUserAutority(account.getId(), role);
		return account;
	}

	public Account findById(String username) {
		return accountMapper.readAccount(username);
	}
	
	public List<String> findAuthoritiesByID(String username){
		return accountMapper.readAutorities(username);
	}
	
	public void updatePassword(String id, String password){
		accountMapper.updatePassword(id,password);
	}
	
	public boolean deleteUser(String id){
		accountMapper.deleteAccount(id);
		return true;
	}
	
	public boolean deleteAutorities(String id){
		accountMapper.deleteAuthorities(id);
		return true;
	}
	
}
