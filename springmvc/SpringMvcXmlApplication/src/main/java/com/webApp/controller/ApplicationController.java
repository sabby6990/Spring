package com.webApp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ApplicationController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String mvcMessage1(ModelMap model){
		model.addAttribute("message", "i am mvc message 1");
		return "Welcome";
	}
	
	@RequestMapping(value="/message2",method=RequestMethod.GET)
	public String mvcMessage2(ModelMap modelMap){
		modelMap.addAttribute("message", "i am mvc message 2");
		return "Welcome2";
	}
}
