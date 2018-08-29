package kr.ac.fcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.dao.MemberDAO;

@Service("reviseMemberInfoService")
public class ReviseMemberInfoServiceImpl implements ReviseMyInfoService{
	
	@Autowired
	private MemberDAO memberDao;

	@Override
	public Account reviseMyInfo(Account member) {
		memberDao.reviseMemberData((MemberDTO)member);
		return member;
	}
	
}