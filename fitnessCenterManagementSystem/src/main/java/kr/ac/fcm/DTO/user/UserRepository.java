package kr.ac.fcm.DTO.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import kr.ac.fcm.service.FindUserService;
/*
 * UserFactory
 */
@Configuration
public class UserRepository {
	
	@Autowired
	private FindUserService findUserService;
	
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ManagerDTO getManager(String id, String type){
		ManagerDTO manager=findUserService.findManagerById(id);
		manager.setType(type);
		return manager;	
	}
	
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public MemberDTO getMember(String id, String type){
		MemberDTO member=findUserService.findMemberById(id);
		member.setType(type);
		return member;	
	}
	
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public TrainerDTO getTrainer(String id, String type){
		TrainerDTO trainer=findUserService.findTrainerById(id);
		trainer.setType(type);
		return trainer;	
	}
	
	
	
}
