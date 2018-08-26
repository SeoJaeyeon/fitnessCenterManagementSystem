package kr.ac.fcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.mapper.MemberMapper;
import kr.ac.fcm.mapper.TrainerMapper;

@Service
public class ReviseUserInfoServiceImpl implements ReviseUserInfoServiceByManager {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	TrainerMapper trainerMapper;

	@Override
	public void reviseMemberInfo(MemberDTO member) {
		// TODO 주 pt횟수와 담당트레이너만 변경 가능 
		memberMapper.updateMemberInfoByManager(member);
	}

	@Override
	public void reviseTrainerInfo(TrainerDTO account) {
		// TODO Auto-generated method stub

	}

}
