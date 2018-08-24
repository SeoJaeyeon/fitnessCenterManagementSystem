package kr.ac.fcm.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.fcm.DTO.user.Account;
import kr.ac.fcm.DTO.user.CenterDTO;
import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.mapper.CenterMapper;
import kr.ac.fcm.mapper.ManagerMapper;

@Service
public class AddManagerService {
	@Autowired
	private AccountService accountService;
	@Autowired
	private ManagerMapper managerMapper;
	@Autowired
	private CenterMapper centerMapper;

	@Transactional
	public void addManager(ManagerDTO manager, CenterDTO center) throws Exception {
		// TODO Auto-generated method stub
		Account account=new Account();
		account.setId(manager.getId());
		account.setType("MANAGER");
		account.setPassword(manager.getPassword());
		account.setCenter_id(center.getCenter_id());
		accountService.save(account, "ROLE_MANAGER", "MANAGER");
		managerMapper.insertManager(manager);
		centerMapper.insertCenterData(center);
			
	}
}
