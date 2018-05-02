package com.uepb.controlebiblioteca.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uepb.controlebiblioteca.model.Revista;
import com.uepb.controlebiblioteca.service.RevistaService;
import com.uepb.controlebiblioteca.util.Principal;

@Controller
public class RevistaController {

	private static final Logger logger = Logger.getLogger(RevistaController.class);

	public RevistaController() {
		System.out.println("RevistaController()");
	}

	@Autowired
	private RevistaService revistaService;

	@RequestMapping(value = "/revistas")
	public ModelAndView listRevista(ModelAndView model, Principal principal) throws IOException {
		List<Revista> listRevista = revistaService.getAllRevistas();
		model = principal.userDetail(model, "revistas/index");
		model.addObject("listRevista", listRevista);
		return model;
	}
	
	@RequestMapping(value = "/newRevista", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		Revista revista = new Revista();
		model = principal.userDetail(model, "revistas/form");
		model.addObject("revista", revista);		
		return model;
	}

	@RequestMapping(value = "/saveRevista", method = RequestMethod.POST)
	public ModelAndView saveRevista(@ModelAttribute Revista revista) {
		if (revista.getId() == 0) { // if revista id is 0 then creating the
			// revista other updating the revista
			revistaService.addRevista(revista);
		} else {
			revistaService.updateRevista(revista);
		}
		return new ModelAndView("redirect:/revistas");
	}

	@RequestMapping(value = "/deleteRevista", method = RequestMethod.GET)
	public ModelAndView deleteRevista(HttpServletRequest request) {
		int revistaId = Integer.parseInt(request.getParameter("id"));
		revistaService.deleteRevista(revistaId);
		return new ModelAndView("redirect:/revistas");
	}

	@RequestMapping(value = "/editRevista", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int revistaId = Integer.parseInt(request.getParameter("id"));
		Revista revista = revistaService.getRevista(revistaId);
		Principal principal = new Principal();
		ModelAndView model = new ModelAndView();
		model = principal.userDetail(model, "revistas/form");	
		model.addObject("revista", revista);
		return model;
	}

}