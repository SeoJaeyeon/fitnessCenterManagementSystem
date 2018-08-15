package kr.ac.fcm.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.ac.fcm.mapper.AccountMapper;
import kr.ac.fcm.mapper.TrainerMapper;
import kr.ac.fcm.user.Trainer;

@Service
public class ReviseMyInfoServiceImpl implements ReviseMyInfoService {
	Logger logger=LoggerFactory.getLogger(ReviseMyInfoService.class);
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private TrainerMapper trainerMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	@Transactional
	public String reviseTrainerInfo(String oldpassword, Trainer trainer) {
		UserDetails account=accountService.loadUserByUsername(trainer.getId());
		if(!passwordEncoder.matches(oldpassword, account.getPassword())){
			return "비밀번호를 확인해주세요!";
		}
		try{
			trainerMapper.updateTrainer(trainer);
			accountMapper.updatePassword(trainer.getId(),passwordEncoder.encode(trainer.getPassword()));
		}catch(Exception e){
			e.printStackTrace();
			return "예기치 못한 오류가 발생했습니다";
		}
		return "정상적으로 변경되었습니다.";
	}

}