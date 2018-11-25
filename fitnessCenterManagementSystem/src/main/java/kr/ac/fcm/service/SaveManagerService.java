package kr.ac.fcm.service;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.fcm.DTO.user.CenterDTO;
import kr.ac.fcm.DTO.user.ManagerDTO;
import kr.ac.fcm.dao.CenterDAO;
import kr.ac.fcm.dao.ManagerDAO;


/*
 * Create fitness center Manager service 
 */
@Service
public class SaveManagerService {
	
	private ManagerDAO managerDao;

	private CenterDAO centerDao;
	
	@Autowired
	public void setManagerDao(ManagerDAO managerDao){
		this.managerDao=managerDao;
	}
	
	@Autowired
	public void setCenterDao(CenterDAO centerDao){
		this.centerDao=centerDao;
	}
	
	@Transactional
	public void saveManager(ManagerDTO manager, CenterDTO center) throws Exception {
		managerDao.saveManager(manager);
		centerDao.saveCenter(center);
	}
}
