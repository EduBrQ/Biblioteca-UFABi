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

/**
 * FuncionarioController representa os serviços de controle de crud Funcionario.
 * @author Eduardo Borba
 *
 */
@Controller
public class FuncionarioController {

	private static final Logger logger = Logger.getLogger(FuncionarioController.class);

	public FuncionarioController() {
		System.out.println("FuncionarioController()");
	}

	/**
	 * Interface FuncionarioService atribuida a funcionarioService
	 */
	@Autowired
	private FuncionarioService funcionarioService;

	/**
	 * Este método retorna uma view 
	 * com uma lista atualizada de Funcionarios. 
	 *
	 */
	@RequestMapping(value = "/funcionarios")
	public ModelAndView listFuncionario(ModelAndView model, Principal principal) throws IOException {
		List<Funcionario> listFuncionario = funcionarioService.getAllFuncionarios();
		model = principal.userDetail(model, "funcionarios/index");
		model.addObject("listFuncionario", listFuncionario);
		return model;
	}

	/**
	 * Este método retorna a inicializacao de 
	 * um novo Funcionario, utilizando a rota: /newFuncionario
	 */
	@RequestMapping(value = "/newFuncionario", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		Funcionario funcionario = new Funcionario();
		model = principal.userDetail(model, "funcionarios/form");
		model.addObject("funcionario", funcionario);
		return model;
	}

	/**
	 * Este método salva um novo funcionario caso o parametro id do funcionario seja igual a 0
	 * Caso contraio ele atualiza o usuario com o id referente.
	 * rota: /saveAluno
	 */
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
	
	/**
	 * Este método deleta o Funcionario relacionado ao id passado como parametro
	 * rota: /deleteFuncionario
	 * 
	 */
	@RequestMapping(value = "/deleteFuncionario", method = RequestMethod.GET)
	public ModelAndView deleteFuncionario(HttpServletRequest request) {
		int funcionarioId = Integer.parseInt(request.getParameter("id"));
		funcionarioService.deleteFuncionario(funcionarioId);
		return new ModelAndView("redirect:/funcionarios");
	}

	/**
	 * Este método edita um Funcionario, recebendo como paramentro de busca
	 * de dados o id do Funcionario e carregando seus dados em uma view,
	 * os dados podem ser editados e então salvos, sobrepondo as mudancas
	 * nos dados existentes referente ao funcionario
	 */
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