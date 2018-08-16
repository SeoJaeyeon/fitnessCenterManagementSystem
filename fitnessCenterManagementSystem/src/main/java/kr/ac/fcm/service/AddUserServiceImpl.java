package kr.ac.fcm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.CenterDTO;
import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.DTO.user.MemberDTO;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.mapper.CenterMapper;
import kr.ac.fcm.mapper.ManagerMapper;
import kr.ac.fcm.mapper.MemberMapper;
import kr.ac.fcm.mapper.TrainerMapper;

@Service
public class AddUserServiceImpl implements AddUserService {
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
	public void addMember(MemberDTO member) {
		Account account=new Account();
		account.setId(member.getId());
		account.setPassword(member.getPassword());
		account.setType("MEMBER");
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
		accountService.save(account, "ROLE_TRAINER", "TRAINER");
		trainerMapper.insertTrainer(trainer);
	}
// id         | name      | center_id | birthdate  | gender | closed_day | phone_number 
	@Override
	@Transactional
	public void addManager(ManagerDTO manager, CenterDTO center) throws Exception {
		// TODO Auto-generated method stub
		Account account=new Account();
		account.setId(manager.getId());
		account.setType("MANAGER");
		account.setPassword(manager.getPassword());
		managerMapper.insertManager(manager);
		centerMapper.insertCenterData(center);
		
		
	}



}
