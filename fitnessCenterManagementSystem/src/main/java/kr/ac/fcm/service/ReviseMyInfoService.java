package kr.ac.fcm.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.mapper.MemberMapper;


public interface ReviseMyInfoService {

	public String reviseMyInfo(String oldpassword, Account trainer) ;
	//public String reviseMemberInfo(String oldpassword, MemberDTO member);
}
