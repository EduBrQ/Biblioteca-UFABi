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

import com.uepb.controlebiblioteca.model.Funcionario;
import com.uepb.controlebiblioteca.service.FuncionarioService;
import com.uepb.controlebiblioteca.util.Principal;

@Controller
public class FuncionarioController {

	private static final Logger logger = Logger.getLogger(FuncionarioController.class);

	public FuncionarioController() {
		System.out.println("FuncionarioController()");
	}

	@Autowired
	private FuncionarioService funcionarioService;

	@RequestMapping(value = "/funcionarios")
	public ModelAndView listFuncionario(ModelAndView model, Principal principal) throws IOException {
		List<Funcionario> listFuncionario = funcionarioService.getAllFuncionarios();
		model = principal.userDetail(model, "funcionarios/index");
		model.addObject("listFuncionario", listFuncionario);
		return model;
	}

	@RequestMapping(value = "/newFuncionario", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		Funcionario funcionario = new Funcionario();
		model = principal.userDetail(model, "funcionarios/form");
		model.addObject("funcionario", funcionario);
		return model;
	}

	@RequestMapping(value = "/saveFuncionario", method = RequestMethod.POST)
	public ModelAndView saveFuncionario(@ModelAttribute Funcionario funcionario) {
		if (funcionario.getId() == 0) { // if funcionario id is 0 then creating the
			// funcionario other updating the funcionario
			funcionarioService.addFuncionario(funcionario);
		} else {
			funcionarioService.updateFuncionario(funcionario);
		}
		return new ModelAndView("redirect:/funcionarios");
	}

	@RequestMapping(value = "/deleteFuncionario", method = RequestMethod.GET)
	public ModelAndView deleteFuncionario(HttpServletRequest request) {
		int funcionarioId = Integer.parseInt(request.getParameter("id"));
		funcionarioService.deleteFuncionario(funcionarioId);
		return new ModelAndView("redirect:/funcionarios");
	}

	@RequestMapping(value = "/editFuncionario", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int funcionarioId = Integer.parseInt(request.getParameter("id"));
		Funcionario funcionario = funcionarioService.getFuncionario(funcionarioId);
		Principal principal = new Principal();
		ModelAndView model = new ModelAndView();
		model = principal.userDetail(model, "funcionarios/form");	
		model.addObject("funcionario", funcionario);
		return model;
	}

}