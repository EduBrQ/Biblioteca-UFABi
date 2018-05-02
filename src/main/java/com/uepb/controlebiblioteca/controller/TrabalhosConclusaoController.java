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

import com.uepb.controlebiblioteca.model.TrabalhosConclusao;
import com.uepb.controlebiblioteca.service.TrabalhosConclusaoService;
import com.uepb.controlebiblioteca.util.Principal;

@Controller
public class TrabalhosConclusaoController {

	private static final Logger logger = Logger.getLogger(TrabalhosConclusaoController.class);

	public TrabalhosConclusaoController() {
		System.out.println("TrabalhosConclusaoController()");
	}

	@Autowired
	private TrabalhosConclusaoService trabalhosConclusaoService;

	@RequestMapping(value = "/trabalhosConclusao")
	public ModelAndView listTrabalhosConclusao(ModelAndView model, Principal principal) throws IOException {
		List<TrabalhosConclusao> listTrabalhosConclusao = trabalhosConclusaoService.getAllTrabalhosConclusaos();
		model = principal.userDetail(model, "trabalhosConclusao/index");
		model.addObject("listTrabalhosConclusao", listTrabalhosConclusao);
		return model;
	}
	
	@RequestMapping(value = "/newTrabalhosConclusao", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		TrabalhosConclusao trabalhosConclusao = new TrabalhosConclusao();
		model = principal.userDetail(model, "trabalhosConclusao/form");
		model.addObject("trabalhosConclusao", trabalhosConclusao);
		return model;
	}

	@RequestMapping(value = "/saveTrabalhosConclusao", method = RequestMethod.POST)
	public ModelAndView saveTrabalhosConclusao(@ModelAttribute TrabalhosConclusao trabalhosConclusao) {
		if (trabalhosConclusao.getId() == 0) { // if trabalhosConclusao id is 0 then creating the
			// trabalhosConclusao other updating the trabalhosConclusao
			trabalhosConclusaoService.addTrabalhosConclusao(trabalhosConclusao);
		} else {
			trabalhosConclusaoService.updateTrabalhosConclusao(trabalhosConclusao);
		}
		return new ModelAndView("redirect:/trabalhosConclusao");
	}

	@RequestMapping(value = "/deleteTrabalhosConclusao", method = RequestMethod.GET)
	public ModelAndView deleteTrabalhosConclusao(HttpServletRequest request) {
		int trabalhosConclusaoId = Integer.parseInt(request.getParameter("id"));
		trabalhosConclusaoService.deleteTrabalhosConclusao(trabalhosConclusaoId);
		return new ModelAndView("redirect:/trabalhosConclusao");
	}

	@RequestMapping(value = "/editTrabalhosConclusao", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int trabalhosConclusaoId = Integer.parseInt(request.getParameter("id"));
		TrabalhosConclusao trabalhosConclusao = trabalhosConclusaoService.getTrabalhosConclusao(trabalhosConclusaoId);
		Principal principal = new Principal();
		ModelAndView model = new ModelAndView();
		model = principal.userDetail(model, "trabalhosConclusao/form");			
		model.addObject("trabalhosConclusao", trabalhosConclusao);
		return model;
	}

}