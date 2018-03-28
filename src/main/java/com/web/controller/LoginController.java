package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		return "login";
		
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(ModelMap model, @RequestParam("email") String email, @RequestParam("senha") String senha) {
		
		return "signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(ModelMap model) {
		
		return "signup";
	}
}
