package aloha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller					// 해당 클래스를 컨트롤러로 지정
public class HomeController {

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")	//경로
	public String home(Model model) {
		
		//view응답
		return "index";
	}
	
	
}
