package kr.ac.fcm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.DTO.user.CenterDTO;
import kr.ac.fcm.mapper.CenterMapper;

@Repository
public class CenterDAO {
	@Autowired
	private CenterMapper centerMapper;
	
	public CenterDTO saveCenter(CenterDTO center){
		centerMapper.insertCenterData(center);
		return center;
	}
	
}