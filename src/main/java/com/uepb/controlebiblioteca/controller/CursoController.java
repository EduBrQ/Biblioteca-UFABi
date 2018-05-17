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

import com.uepb.controlebiblioteca.model.Curso;
import com.uepb.controlebiblioteca.service.CursoService;
import com.uepb.controlebiblioteca.util.Principal;

/**
 * CursoController representa os serviços de controle de crud de Cursos.
 * @author Eduardo Borba
 *
 */
@Controller
public class CursoController {

	private static final Logger logger = Logger.getLogger(CursoController.class);

	public CursoController() {
		System.out.println("CursoController()");
	}
	/**
	 * Define a interface cursoService para essa classe.
	 */
	@Autowired
	private CursoService cursoService;

	/**
	 * rota [/cursos], e retorna 
	 * uma view com o modelo definido [carregar todos os cursos.
	 * 
	 * @param model - modelo de rota de view.
	 * @param principal - rota principal definida pelo parametro passado.
	 * @throws IOException - tratamento de exceção.
	 */
	@RequestMapping(value = "/cursos")
	public ModelAndView listCurso(ModelAndView model, Principal principal) throws IOException {

		List<Curso> listCurso = cursoService.getAllCursos();
		model = principal.userDetail(model, "cursos/index");
		model.addObject("listCurso", listCurso);
		return model;
	}


	/**
	 * Metodo de retorno de view, rota: [/newCurso]. 
	 * Criar um novo curso.
	 *
	 */
	@RequestMapping(value = "/newCurso", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		Curso curso = new Curso();
		model = principal.userDetail(model, "cursos/form");
		model.addObject("curso", curso);
		return model;
	}

	/**
	 * rota: [/saveCurso].
	 * Salva dados referente a um curso. 
	 * 
	 * @param curso - curso como parametro de comparacao, para saber 
	 * se irá adicionar um novo curso ou se irá apenas atualizar algum existente.
	 * 
	 * @return - retorna a view /cursos.
	 */
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

	/**
	 * rota: [/deleteCurso].
	 * Deleta o curso.
	 * @param cursoId - usa como parametro de busca o id 
	 * do curso passado, e deleta o curso referente.
	 */
	@RequestMapping(value = "/deleteCurso", method = RequestMethod.GET)
	public ModelAndView deleteCurso(HttpServletRequest request) {
		int cursoId = Integer.parseInt(request.getParameter("id"));
		cursoService.deleteCurso(cursoId);
		return new ModelAndView("redirect:/cursos");
	}

	/**
	 * rota: [/editCurso]
	 * Edita o curso selecionado.
	 * @param cursoId - usa como parametro de busca o id do curso passado, 
	 * carrega os dados referentes e mostra a view com os dados para editar.
	 * 
	 */
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