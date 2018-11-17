package kr.ac.fcm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.fcm.DTO.user.CenterDTO;
import kr.ac.fcm.mapper.CenterMapper;

@Repository
public class CenterDAO {

	private CenterMapper centerMapper;
	
	@Autowired
	public void setCenterMapper(CenterMapper centerMapper){
		this.centerMapper=centerMapper;
	}
	
	public CenterDTO saveCenter(CenterDTO center){
		centerMapper.insertCenterData(center);
		return center;
	}
	
}
