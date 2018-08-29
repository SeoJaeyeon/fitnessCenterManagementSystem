package kr.ac.fcm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.dao.AccountDAO;

/**
 * 
 * @author seojaeyeon
 * spring-security UserDetailsService 구현
 * passwordEncoder- Default 
 * 
 */
@Service
public class AccountService implements UserDetailsService{
	
	
	@Autowired
	AccountDAO accountDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account account=accountDao.findById(username);
		account.setAuthorities(getAuthorities(username));
		
		UserDetails userDetails=new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				return true;
			}
			
			@Override
			public String getUsername() {
				return account.getId();
			}
			
			@Override
			public String getPassword() {
				return account.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return account.getAuthorities();
			}

		};
		return account;
	}

	public Account save(Account account,String role,String type) {

		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.setAccountNonExpired(true);
		account.setAccountNonLocked(true);
		account.setCredentialsNonExpired(true);
		account.setEnabled(true);
		account.setType(type);
		accountDao.save(account);
		accountDao.saveAutority(account, role);
		
		return account;
	}
	public Collection<GrantedAuthority> getAuthorities(String username) 
	{ 
		List<String> string_authorities = accountDao.findAuthoritiesByID(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		for (String authority : string_authorities) 
		{ 
			authorities.add(new SimpleGrantedAuthority(authority)); 
		} 
		return authorities; 
	}





}
