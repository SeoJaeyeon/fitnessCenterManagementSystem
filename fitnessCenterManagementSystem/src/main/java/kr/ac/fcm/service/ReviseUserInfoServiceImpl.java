package kr.ac.fcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.dao.MemberDAO;
import kr.ac.fcm.dao.TrainerDAO;

@Service
public class ReviseUserInfoServiceImpl implements ReviseUserInfoServiceByManager {
	
	private MemberDAO memberDao;
	
	private TrainerDAO trainerDao;
	
	
	@Autowired
	public void setMemberDao(MemberDAO memberDao){
		this.memberDao=memberDao;
	}
	
	@Autowired
	public void setTrainerDao(TrainerDAO trainerDao){
		this.trainerDao=trainerDao;
	}

	@Override
	public MemberDTO reviseMemberInfo(MemberDTO member) {
		// TODO 주 pt횟수와 담당트레이너만 변경 가능 
		return memberDao.reviseMemberDataByManager(member);
	}

	@Override
	public TrainerDTO reviseTrainerInfo(TrainerDTO trainer) {
		// TODO 휴무일만 변경 가능 
		return trainerDao.reviseTrainerDataMyManager(trainer);
	}

}
