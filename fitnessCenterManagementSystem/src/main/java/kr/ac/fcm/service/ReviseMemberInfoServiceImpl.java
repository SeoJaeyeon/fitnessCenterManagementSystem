package kr.ac.fcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.mapper.AccountMapper;
import kr.ac.fcm.mapper.MemberMapper;

@Service("reviseMemberInfoService")
public class ReviseMemberInfoServiceImpl implements ReviseMyInfoService{
	@Autowired
	private AccountService accountService;
	@Autowired 
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AccountMapper accountMapper;
	@Override
	public String reviseMyInfo(String oldpassword, Account member) {
		UserDetails account=accountService.loadUserByUsername(member.getId());
		if(!passwordEncoder.matches(oldpassword, account.getPassword())){
			return "pwerror";
		}
		try{
			memberMapper.reviseMemberData((MemberDTO)member);
			accountMapper.updatePassword(member.getId(),passwordEncoder.encode(member.getPassword()));
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
}