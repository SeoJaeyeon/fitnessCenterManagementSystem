package kr.ac.fcm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.dao.AccountDAO;
import kr.ac.fcm.dao.MemberDAO;
import kr.ac.fcm.dao.TrainerDAO;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	
	@Autowired
	private AccountDAO accountDao;
	
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private TrainerDAO trainerDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public MemberDTO addMember(MemberDTO member) {
		Account account=new Account();
		account.setId(member.getId());
		account.setPassword(member.getPassword());
		account.setCenter_id(member.getCenter_id());
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.setType("MEMBER");
		accountDao.save(account);
		accountDao.saveAutority(account, "ROLE_MEMBER");		
		
		return memberDao.saveMember(member);
	}

	@Override
	@Transactional
	public TrainerDTO addTrainer(TrainerDTO trainer) {
		Account account=new Account();
		account.setId(trainer.getId());
		account.setType("TRAINER");
		account.setPassword(trainer.getPassword());
		account.setCenter_id(trainer.getCenter_id());
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountDao.save(account);
		accountDao.saveAutority(account, "ROLE_TRAINER");	
		
		return trainerDao.saveTrainer(trainer);
	}

	@Override
	@Transactional
	public String removeMember(String id) {
		accountDao.deleteAutorities(id);
		accountDao.deleteUser(id);
		memberDao.deleteMember(id);
		return id;
	}

	@Override
	@Transactional
	public String removeTrainer(String id) {
		accountDao.deleteAutorities(id);
		accountDao.deleteUser(id);
		trainerDao.deleteTrainer(id);
		return id;
	}




}
