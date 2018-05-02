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

@Controller
public class AlunoController {

	private static final Logger logger = Logger.getLogger(AlunoController.class);

	public AlunoController() {
		System.out.println("AlunoController()");
	}

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private CursoService cursoService;

	@RequestMapping(value = "/alunos")
	public ModelAndView listAluno(ModelAndView model, Principal principal) throws IOException {
		List<Aluno> listAluno = alunoService.getAllAlunos();
		model = principal.userDetail(model, "alunos/index");
		model.addObject("listAluno", listAluno);
		return model;
	}
	
	@RequestMapping(value = "/newAluno", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		List<Curso> cursos = cursoService.getAllCursos();
		Aluno aluno = new Aluno();
		model = principal.userDetail(model, "alunos/form");
		model.addObject("aluno", aluno);
		model.addObject("cursos", cursos);
		return model;
	}

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

	@RequestMapping(value = "/deleteAluno", method = RequestMethod.GET)
	public ModelAndView deleteAluno(HttpServletRequest request) {
		int alunoId = Integer.parseInt(request.getParameter("id"));
		alunoService.deleteAluno(alunoId);
		return new ModelAndView("redirect:/alunos");
	}

	@RequestMapping(value = "/editAluno", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int alunoId = Integer.parseInt(request.getParameter("id"));
		Aluno aluno = alunoService.getAluno(alunoId);		
		Principal principal = new Principal();		
		ModelAndView model = new ModelAndView();		
		model = principal.userDetail(model, "alunos/form");
		model.addObject("aluno", aluno);
		return model;
	}

}