package kr.ac.fcm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.mapper.CenterMapper;
import kr.ac.fcm.mapper.ManagerMapper;
import kr.ac.fcm.mapper.MemberMapper;
import kr.ac.fcm.mapper.TrainerMapper;
import kr.ac.fcm.user.Account;
import kr.ac.fcm.user.Center;
import kr.ac.fcm.user.Manager;
import kr.ac.fcm.user.Member;
import kr.ac.fcm.user.Trainer;

@Service
public class AddUserImpl implements AddUser {
	@Autowired
	private AccountService accountService;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private TrainerMapper trainerMapper;
	@Autowired
	private ManagerMapper managerMapper;
	@Autowired
	private CenterMapper centerMapper;
	
	@Override
	@Transactional
	public void addMember(Member member) {
		Account account=new Account();
		account.setId(member.getId());
		account.setPassword(member.getPassword());
		account.setType("MEMBER");
		accountService.save(account, "ROLE_MEMBER", "MEMBER");
		memberMapper.insertMember(member);
	}

	@Override
	@Transactional
	public void addTrainer(Trainer trainer) {
		Account account=new Account();
		account.setId(trainer.getId());
		account.setType("TRAINER");
		account.setPassword(trainer.getPassword());
		accountService.save(account, "ROLE_TRAINER", "TRAINER");
		trainerMapper.insertTrainer(trainer);
	}

	@Override
	@Transactional
	public void addManager(Manager manager, Center center) throws Exception {
		// TODO Auto-generated method stub
		Account account=new Account();
		account.setId(manager.getId());
		account.setType("MANAGER");
		account.setPassword(manager.getPassword());
		managerMapper.insertManager(manager);
		centerMapper.insertCenterData(center);
		
		
	}



}
