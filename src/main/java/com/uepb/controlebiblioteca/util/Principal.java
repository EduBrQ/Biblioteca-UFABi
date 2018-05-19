package com.uepb.controlebiblioteca.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

/**
 * Principal representa uma classe com uma funcionalidade de modelandview
 * @author Eduardo Borba
 *
 */
public class Principal {
	/**
	 * ModelAndView retorna um modelo com uma view baseada nos parametros passados, model e view.
	 * @param model
	 * @param view
	 * 
	 */
	public ModelAndView userDetail(ModelAndView model, String view) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    model.addObject("username", name);
	    model.setViewName(view);
	    return model;
	}

}
