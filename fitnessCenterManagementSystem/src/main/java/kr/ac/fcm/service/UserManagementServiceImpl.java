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
	
	private AccountDAO accountDao;
	
	private MemberDAO memberDao;
	
	private TrainerDAO trainerDao;
	
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public void setAccountDao(AccountDAO accountDao){
		this.accountDao=accountDao;
	}
	
	@Autowired
	public void setMemberDao(MemberDAO memberDao){
		this.memberDao=memberDao;
	}
	
	@Autowired
	public void setTrainerDao(TrainerDAO trainerDao){
		this.trainerDao=trainerDao;
	}
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder){
		this.passwordEncoder=passwordEncoder;
	}
	
	
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
