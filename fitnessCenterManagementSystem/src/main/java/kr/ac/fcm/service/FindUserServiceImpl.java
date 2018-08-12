package kr.ac.fcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.mapper.ManagerMapper;
import kr.ac.fcm.mapper.MemberMapper;
import kr.ac.fcm.mapper.TrainerMapper;
import kr.ac.fcm.user.Manager;
import kr.ac.fcm.user.Member;
import kr.ac.fcm.user.Trainer;

@Service
public class FindUserServiceImpl implements FindUserService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private TrainerMapper trainerMapper;
	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	public Manager findManagerById(String id) {
		// TODO Auto-generated method stub
		return managerMapper.findManagerByManagerId(id);
	}

	@Override
	public Trainer findTrainerById(String id) {
		// TODO Auto-generated method stub
		return trainerMapper.findTrainerByTrainerId(id);
	}

	@Override
	public Member findMemberById(String id) {
		// TODO Auto-generated method stub
		return memberMapper.findMemberByMemberId(id);
	}

}
