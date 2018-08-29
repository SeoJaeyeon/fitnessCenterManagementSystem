package kr.ac.fcm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.DTO.user.TrainerDTO;
import kr.ac.fcm.mapper.TrainerMapper;

/*
 * read trainer
 */
@Repository
public class TrainerDAO {
	@Autowired
	private TrainerMapper trainerMapper;
	
	public TrainerDTO findTrainerById(String id) {
		return trainerMapper.findTrainerByTrainerId(id);
	}
	
	public List<TrainerDTO> findAllTrainers(String center_id) {
		List<TrainerDTO> trainers=trainerMapper.selectAllTrainerByCenter_id(center_id);
		return trainers;
	}
}
