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

import com.uepb.controlebiblioteca.model.Livro;
import com.uepb.controlebiblioteca.service.LivroService;
import com.uepb.controlebiblioteca.util.Principal;

@Controller
public class LivroController {

	private static final Logger logger = Logger.getLogger(LivroController.class);

	public LivroController() {
		System.out.println("LivroController()");
	}

	@Autowired
	private LivroService livroService;

	@RequestMapping(value = "/livros")
	public ModelAndView listLivro(ModelAndView model, Principal principal) throws IOException {
		List<Livro> listLivro = livroService.getAllLivros();
		model = principal.userDetail(model, "livros/index");
		model.addObject("listLivro", listLivro);
		return model;
	}
	
	@RequestMapping(value = "/newLivro", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		Livro livro = new Livro();
		model = principal.userDetail(model, "livros/form");
		model.addObject("livro", livro);
		return model;
	}

	@RequestMapping(value = "/saveLivro", method = RequestMethod.POST)
	public ModelAndView saveLivro(@ModelAttribute Livro livro) {
		if (livro.getId() == 0) { // if livro id is 0 then creating the
			// livro other updating the livro
			livroService.addLivro(livro);
		} else {
			livroService.updateLivro(livro);
		}
		return new ModelAndView("redirect:/livros");
	}

	@RequestMapping(value = "/deleteLivro", method = RequestMethod.GET)
	public ModelAndView deleteLivro(HttpServletRequest request) {
		int livroId = Integer.parseInt(request.getParameter("id"));
		livroService.deleteLivro(livroId);
		return new ModelAndView("redirect:/livros");
	}

	@RequestMapping(value = "/editLivro", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int livroId = Integer.parseInt(request.getParameter("id"));
		Livro livro = livroService.getLivro(livroId);
		Principal principal = new Principal();
		ModelAndView model = new ModelAndView();
		model = principal.userDetail(model, "livros/form");	
		model.addObject("livro", livro);
		return model;
	}

}