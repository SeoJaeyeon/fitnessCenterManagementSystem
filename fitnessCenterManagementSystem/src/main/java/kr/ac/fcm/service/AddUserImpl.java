package kr.ac.fcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.mapper.MemberMapper;
import kr.ac.fcm.mapper.TrainerMapper;
import kr.ac.fcm.user.Account;
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
	
	@Override
	public void addMember(Member member) {
		memberMapper.insertMember(member);
	}

	@Override
	public void addTrainer(Trainer trainer) {
		trainerMapper.insertTrainer(trainer);
	}

	@Override
	public void addAccount(Account account, String type) {
		// TODO Auto-generated method stub
	
		if(type.equals("member"))
			accountService.save(account, "ROLE_MEMBER", "MEMBER");
		
		if(type.equals("trainer"))
			accountService.save(account, "ROLE_TRAINER", "TRAINER");
		

	}

}
