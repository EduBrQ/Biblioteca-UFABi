package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		return "curso";
	}
}
