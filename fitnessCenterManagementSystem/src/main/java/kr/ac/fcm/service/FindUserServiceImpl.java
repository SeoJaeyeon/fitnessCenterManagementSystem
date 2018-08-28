package kr.ac.fcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.MemberTrDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.mapper.ManagerMapper;
import kr.ac.fcm.mapper.MemberMapper;
import kr.ac.fcm.mapper.TrainerMapper;

@Service
public class FindUserServiceImpl implements FindUserService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private TrainerMapper trainerMapper;
	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	public ManagerDTO findManagerById(String id) {
		// TODO Auto-generated method stub
		return managerMapper.findManagerByManagerId(id);
	}

	@Override
	public TrainerDTO findTrainerById(String id) {
		// TODO Auto-generated method stub
		return trainerMapper.findTrainerByTrainerId(id);
	}

	@Override
	public MemberDTO findMemberById(String id) {
		// TODO Auto-generated method stub
		return memberMapper.findMemberByMemberId(id);
	}

	@Override
	public List<TrainerDTO> findAllTrainers(String center_id) {
		// TODO Auto-generated method stub
		List<TrainerDTO> trainers=trainerMapper.selectAllTrainerByCenter_id(center_id);
		return trainers;
	}

	@Override
	@Transactional
	public List<MemberTrDTO> findAllMembers(String center_id) {
		// TODO Auto-generated method stub
		List<MemberTrDTO> members=memberMapper.selectAllMembersWithTrainer(center_id);
		members.addAll(memberMapper.selectAllMemberWithNullTrainer(center_id));
		return members;
	}

}
