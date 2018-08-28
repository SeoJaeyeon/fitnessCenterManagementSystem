package kr.ac.fcm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.mapper.AccountMapper;
import kr.ac.fcm.mapper.MemberMapper;
import kr.ac.fcm.mapper.TrainerMapper;
import kr.ac.fcm.service.s3.S3Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	@Autowired
	private AccountService accountService;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private TrainerMapper trainerMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private S3Service s3Service;
	
	@Override
	@Transactional
	public void addMember(MemberDTO member) {
		Account account=new Account();
		account.setId(member.getId());
		account.setPassword(member.getPassword());
		account.setType("MEMBER");
		account.setCenter_id(member.getCenter_id());
		accountService.save(account, "ROLE_MEMBER", "MEMBER");
		memberMapper.insertMember(member);
	}

	@Override
	@Transactional
	public void addTrainer(TrainerDTO trainer) {
		Account account=new Account();
		account.setId(trainer.getId());
		account.setType("TRAINER");
		account.setPassword(trainer.getPassword());
		account.setCenter_id(trainer.getCenter_id());
		accountService.save(account, "ROLE_TRAINER", "TRAINER");
		trainerMapper.insertTrainer(trainer);
	}

	@Override
	@Transactional
	public void removeMember(String id) {
		memberMapper.deleteMember(id);	
		accountMapper.deleteUserFromAuth(id);
		accountMapper.deleteUserFromUser(id);
	}

	@Override
	@Transactional
	public void removeTrainer(String id) {
		trainerMapper.deleteTrainer(id);
		accountMapper.deleteUserFromUser(id);
		accountMapper.deleteUserFromAuth(id);	
		s3Service.deleteFile(id);
	}




}
