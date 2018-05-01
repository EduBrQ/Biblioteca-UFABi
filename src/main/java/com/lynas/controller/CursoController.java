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

import com.lynas.model.Curso;
import com.lynas.service.CursoService;
import com.lynas.util.Principal;

@Controller
public class CursoController {

	private static final Logger logger = Logger.getLogger(CursoController.class);

	public CursoController() {
		System.out.println("CursoController()");
	}

	@Autowired
	private CursoService cursoService;

	@RequestMapping(value = "/cursos")
	public ModelAndView listCurso(ModelAndView model, Principal principal) throws IOException {

		List<Curso> listCurso = cursoService.getAllCursos();
		model = principal.userDetail(model, "cursos/index");
		model.addObject("listCurso", listCurso);
		return model;
	}

	@RequestMapping(value = "/newCurso", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		Curso curso = new Curso();
		model = principal.userDetail(model, "cursos/form");
		model.addObject("curso", curso);
		return model;
	}

	@RequestMapping(value = "/saveCurso", method = RequestMethod.POST)
	public ModelAndView saveCurso(@ModelAttribute Curso curso) {
		if (curso.getId() == 0) { // if curso id is 0 then creating the
			// curso other updating the curso
			cursoService.addCurso(curso);
		} else {
			cursoService.updateCurso(curso);
		}
		return new ModelAndView("redirect:/cursos");
	}

	@RequestMapping(value = "/deleteCurso", method = RequestMethod.GET)
	public ModelAndView deleteCurso(HttpServletRequest request) {
		int cursoId = Integer.parseInt(request.getParameter("id"));
		cursoService.deleteCurso(cursoId);
		return new ModelAndView("redirect:/cursos");
	}

	@RequestMapping(value = "/editCurso", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {	
		int cursoId = Integer.parseInt(request.getParameter("id"));	
		Curso curso = cursoService.getCurso(cursoId);
		Principal principal = new Principal();
		ModelAndView model = new ModelAndView();
		model = principal.userDetail(model, "cursos/form");	
		model.addObject("curso", curso);
		return model;
	}

}