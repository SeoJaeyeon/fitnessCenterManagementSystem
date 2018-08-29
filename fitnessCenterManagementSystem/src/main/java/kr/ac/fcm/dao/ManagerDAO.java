package kr.ac.fcm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.DTO.user.CenterDTO;
import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.mapper.CenterMapper;
import kr.ac.fcm.mapper.ManagerMapper;
/*
 *  Create Manager and Center
 *  read Manager
 */
@Repository
public class ManagerDAO {
	@Autowired
	private ManagerMapper managerMapper;

	public ManagerDTO saveManager(ManagerDTO manager){
		managerMapper.insertManager(manager);
		return manager;
	}
	
	public ManagerDTO findManagerById(String id){
		return managerMapper.findManagerByManagerId(id);
	}
}
