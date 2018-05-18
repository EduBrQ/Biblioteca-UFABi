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

import com.uepb.controlebiblioteca.model.Aluno;
import com.uepb.controlebiblioteca.model.Curso;
import com.uepb.controlebiblioteca.service.AlunoService;
import com.uepb.controlebiblioteca.service.CursoService;
import com.uepb.controlebiblioteca.util.Principal;
/**
 * 
 * AlunoController representa os serviços de controle de crud dos alunos.
 * @author Eduardo Borba
 *
 */
@Controller
public class AlunoController {

	private static final Logger logger = Logger.getLogger(AlunoController.class);

	public AlunoController() {
		System.out.println("AlunoController()");
	}

	/**
	 * Define a interface alunoService para essa classe.
	 */
	@Autowired
	private AlunoService alunoService;
	
	/**
	 * Define a interface cursoService para essa classe.
	 */
	@Autowired
	private CursoService cursoService;

	/**
	 * rota [/alunos], e retorna 
	 * uma view com o modelo definido [carregar todos os alunos].
	 * 
	 * @param model - modelo de rota de view.
	 * @param principal - rota principal definida pelo parametro passado.
	 * @throws IOException - tratamento de exceção.
	 */
	@RequestMapping(value = "/alunos")
	public ModelAndView listAluno(ModelAndView model, Principal principal) throws IOException {
		List<Aluno> listAluno = alunoService.getAllAlunos();
		model = principal.userDetail(model, "alunos/index");
		model.addObject("listAluno", listAluno);
		return model;
	}
	
	/**
	 * Metodo de retorno de view, rota: [/newAluno]. 
	 * Criar um novo aluno.
	 * Lista com todos os Cursos anexada.
	 * 
	 * @param model - modelo de rota de view.
	 * @param principal - rota principal definida pelo parametro passado.
	
	 */
	@RequestMapping(value = "/newAluno", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		List<Curso> cursos = cursoService.getAllCursos();
		Aluno aluno = new Aluno();
		model = principal.userDetail(model, "alunos/form");
		model.addObject("aluno", aluno);
		model.addObject("cursos", cursos);
		return model;
	}

	/**
	 * rota: [/saveAluno].
	 * Salva dados referente a um aluno. 
	 * @param aluno - aluno como parametro de comparacao, para saber se vai add um novo aluno ou atualizar
	 */
	@RequestMapping(value = "/saveAluno", method = RequestMethod.POST)
	public ModelAndView saveAluno(@ModelAttribute Aluno aluno) {
		if (aluno.getId() == 0) { // if aluno id is 0 then creating the
			// aluno other updating the aluno
			System.out.println(aluno);
			alunoService.addAluno(aluno);
		} else {
			alunoService.updateAluno(aluno);
		}
		return new ModelAndView("redirect:/alunos");
	}

	/**
	 * rota: [/deleteAluno].
	 * Deleta o aluno.
	 * @param alunoId - usa como parametro de busca o id do aluno passado, e deleta por este.
	 */
	@RequestMapping(value = "/deleteAluno", method = RequestMethod.GET)
	public ModelAndView deleteAluno(HttpServletRequest request) {
		int alunoId = Integer.parseInt(request.getParameter("id"));
		alunoService.deleteAluno(alunoId);
		return new ModelAndView("redirect:/alunos");
	}

	/**
	 * rota: [/editAluno]
	 * Edita o aluno.
	 * @param alunoId - usa como parametro de busca o id do aluno passado, carrega os dados referentes e edita.
	 * 
	 */
	@RequestMapping(value = "/editAluno", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int alunoId = Integer.parseInt(request.getParameter("id"));
		Aluno aluno = alunoService.getAluno(alunoId);	
		List<Curso> cursos = cursoService.getAllCursos();
		Principal principal = new Principal();		
		ModelAndView model = new ModelAndView();		
		model = principal.userDetail(model, "alunos/form");
		model.addObject("cursos", cursos);
		model.addObject("aluno", aluno);
		return model;
	}

}