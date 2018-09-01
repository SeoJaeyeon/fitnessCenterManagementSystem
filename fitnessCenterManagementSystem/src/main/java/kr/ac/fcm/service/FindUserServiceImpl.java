package kr.ac.fcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.MemberTrDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.dao.ManagerDAO;
import kr.ac.fcm.dao.MemberDAO;
import kr.ac.fcm.dao.TrainerDAO;

@Service
public class FindUserServiceImpl implements FindUserService {

	@Autowired
	private ManagerDAO managerDao;
	
	@Autowired
	private TrainerDAO trainerDao;
	
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public ManagerDTO findManagerById(String id) {
		return managerDao.findManagerById(id);
	}

	@Override
	public TrainerDTO findTrainerById(String id) {
		return trainerDao.findTrainerById(id);
	}

	@Override
	public MemberDTO findMemberById(String id) {
		return memberDao.findMemberById(id);
	}

	@Override
	public List<TrainerDTO> findAllTrainers(String center_id) {
		return trainerDao.findAllTrainers(center_id);
	}

	@Override
	@Transactional
	public List<MemberTrDTO> findAllMembers(String center_id) {
		List<MemberTrDTO> members=memberDao.findAllMembersWithTrainer(center_id);
		members.addAll(memberDao.findAllMembersWithNullTrainer(center_id));
		return members;
	}

	@Override
	@Transactional
	public List<MemberTrDTO> findMembersByName(String name, String center_id) {
		List<MemberTrDTO> members=memberDao.findMembersByNameWithTrainer(name, center_id);
		members.addAll(memberDao.findMembersByNameWithNullTrainer(name, center_id));
		return members;
	}

	@Override
	public List<TrainerDTO> findTrainersByName(String name, String center_id) {
		List<TrainerDTO> trainers=trainerDao.findTrainersByName(name, center_id);
		return trainers;
	}

	@Override
	public List<MemberDTO> findMembersByTrainerId(String id) {
		return memberDao.findMembersByTrainerId(id);
	}

}
