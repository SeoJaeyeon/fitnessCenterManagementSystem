package kr.ac.fcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String testView(){
		return "manager/manager";
	}
}
