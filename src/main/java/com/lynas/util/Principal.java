package com.lynas.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

public class Principal {

	
	public ModelAndView userDetail(ModelAndView model, String view) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    model.addObject("username", name);
	    model.setViewName(view);
	    return model;
	}

}
