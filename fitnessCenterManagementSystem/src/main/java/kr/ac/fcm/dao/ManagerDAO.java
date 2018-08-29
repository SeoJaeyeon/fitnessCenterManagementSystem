package kr.ac.fcm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.DTO.user.CenterDTO;
import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.mapper.CenterMapper;
import kr.ac.fcm.mapper.ManagerMapper;
/*
 *  Create Manager and Center
 */
@Repository
public class ManagerDAO {
	@Autowired
	private ManagerMapper managerMapper;
	@Autowired
	private CenterMapper centerMapper;
	
	public ManagerDTO saveManager(ManagerDTO manager){
		managerMapper.insertManager(manager);
		return manager;
	}
	
	public CenterDTO saveCenter(CenterDTO center){
		centerMapper.insertCenterData(center);
		return center;
	}
	

}