package kr.ac.fcm.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.dao.TrainerDAO;


@Service("reviseTrainerInfoService")
public class ReviseTrainerInfoServiceImpl implements ReviseMyInfoService {
	Logger logger=LoggerFactory.getLogger(ReviseMyInfoService.class);
	
	private TrainerDAO trainerDao;
	
	@Autowired
	public void setTrainerDao(TrainerDAO trainerDao){
		this.trainerDao=trainerDao;
	}
	
	@Override
	@Transactional
	public Account reviseMyInfo(Account trainer) {
		trainerDao.reviseTrainerData((TrainerDTO)trainer);
		return trainer;
	}

}
