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

/**
 * LivroController representa os serviços de controle de crud de Livros.
 * @author Eduardo Borba
 *
 */
@Controller
public class LivroController {

	private static final Logger logger = Logger.getLogger(LivroController.class);

	public LivroController() {
		System.out.println("LivroController()");
	}

	/**
	 * Atribui a interface LivroService a livroService
	 */
	@Autowired
	private LivroService livroService;

	/**
	 * Metodo que possui como rota [/livros], e retorna 
	 * uma view com o modelo definido [carregando todos os livros].
	 * 
	 */
	@RequestMapping(value = "/livros")
	public ModelAndView listLivro(ModelAndView model, Principal principal) throws IOException {
		List<Livro> listLivro = livroService.getAllLivros();
		model = principal.userDetail(model, "livros/index");
		model.addObject("listLivro", listLivro);
		return model;
	}
	
	/**
	 * Metodo que cria uma nova instancia do tipo Livro,
	 * retorna uma view com formularios em aberto dos atributos de Livro.
	 */
	@RequestMapping(value = "/newLivro", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		Livro livro = new Livro();
		model = principal.userDetail(model, "livros/form");
		model.addObject("livro", livro);
		return model;
	}

	/**
	 * Metodo para salvar os dados preenchidos de Livro
	 * Se o parametro passado - idLivro for igual 0 entao: addLivro
	 * Se idLivro for diferente de 0 entao: updateLivro 
	 */
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

	/**
	 * Metodo para deletar uma instancia deLivro
	 * recebe como parametro um idLivro e deleta o Livro relacionado.
	 */
	@RequestMapping(value = "/deleteLivro", method = RequestMethod.GET)
	public ModelAndView deleteLivro(HttpServletRequest request) {
		int livroId = Integer.parseInt(request.getParameter("id"));
		livroService.deleteLivro(livroId);
		return new ModelAndView("redirect:/livros");
	}
	
	/**
	 * Metodo para editar um registro de um Livro cadastrado
	 * Busca o livro pelo idLivro
	 * Carrega a tela de formulario com os dados do livro selecionado
	 * Possibilita a edicao e salva as alteracoes
	 */
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