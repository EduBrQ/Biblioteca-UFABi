package com.lynas.controller;

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

import com.lynas.model.AnaisCongresso;
import com.lynas.service.AnaisCongressoService;
import com.lynas.util.Principal;

@Controller
public class AnaisCongressoController {

	private static final Logger logger = Logger.getLogger(AnaisCongressoController.class);

	public AnaisCongressoController() {
		System.out.println("AnaisCongressoController()");
	}

	@Autowired
	private AnaisCongressoService anaisCongressoService;

	@RequestMapping(value = "/anaisCongresso")
	public ModelAndView listAnaisCongresso(ModelAndView model, Principal principal) throws IOException {
		List<AnaisCongresso> listAnaisCongresso = anaisCongressoService.getAllAnaisCongressos();
		model = principal.userDetail(model, "anaisCongresso/index");
		model.addObject("listAnaisCongresso", listAnaisCongresso);
		return model;
	}
	
	@RequestMapping(value = "/newAnaisCongresso", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		AnaisCongresso anaisCongresso = new AnaisCongresso();
		model = principal.userDetail(model, "anaisCongresso/form");
		model.addObject("anaisCongresso", anaisCongresso);
		return model;
	}

	@RequestMapping(value = "/saveAnaisCongresso", method = RequestMethod.POST)
	public ModelAndView saveAnaisCongresso(@ModelAttribute AnaisCongresso anaisCongresso) {
		if (anaisCongresso.getId() == 0) { // if anaisCongresso id is 0 then creating the
			// anaisCongresso other updating the anaisCongresso
			anaisCongressoService.addAnaisCongresso(anaisCongresso);
		} else {
			anaisCongressoService.updateAnaisCongresso(anaisCongresso);
		}
		return new ModelAndView("redirect:/anaisCongresso");
	}

	@RequestMapping(value = "/deleteAnaisCongresso", method = RequestMethod.GET)
	public ModelAndView deleteAnaisCongresso(HttpServletRequest request) {
		int anaisCongressoId = Integer.parseInt(request.getParameter("id"));
		anaisCongressoService.deleteAnaisCongresso(anaisCongressoId);
		return new ModelAndView("redirect:/anaisCongresso");
	}

	@RequestMapping(value = "/editAnaisCongresso", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {		
		int anaisCongressoId = Integer.parseInt(request.getParameter("id"));		
		AnaisCongresso anaisCongresso = anaisCongressoService.getAnaisCongresso(anaisCongressoId);		
		Principal principal = new Principal();		
		ModelAndView model = new ModelAndView();		
		model = principal.userDetail(model, "anaisCongresso/form");		
		model.addObject("anaisCongresso", anaisCongresso);
		return model;
	}

}