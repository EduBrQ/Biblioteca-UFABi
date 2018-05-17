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
import com.uepb.controlebiblioteca.model.AnaisCongresso;
import com.uepb.controlebiblioteca.model.Emprestimo;
import com.uepb.controlebiblioteca.model.Livro;
import com.uepb.controlebiblioteca.model.MidiasEletronicas;
import com.uepb.controlebiblioteca.model.Revista;
import com.uepb.controlebiblioteca.model.TrabalhosConclusao;
import com.uepb.controlebiblioteca.service.AlunoService;
import com.uepb.controlebiblioteca.service.AnaisCongressoService;
import com.uepb.controlebiblioteca.service.EmprestimoService;
import com.uepb.controlebiblioteca.service.LivroService;
import com.uepb.controlebiblioteca.service.MidiasEletronicasService;
import com.uepb.controlebiblioteca.service.RevistaService;
import com.uepb.controlebiblioteca.service.TrabalhosConclusaoService;
import com.uepb.controlebiblioteca.util.Principal;

/**
 * EmprestimoController representa os serviços de controle de Emprestimos.
 * 
 * @author Eduardo Borba
 *
 */
@Controller
public class EmprestimoController {

	private static final Logger logger = Logger.getLogger(EmprestimoController.class);

	public EmprestimoController() {
		System.out.println("EmprestimoController()");
	}
	
	/**
	 * Inicializa nesta classe a interface alunosService
	 */
	@Autowired
	private AlunoService alunosService;
	
	/**
	 * Inicializa nesta classe a interface emprestimoService
	 */
	@Autowired
	private EmprestimoService emprestimoService;
	
	/**
	 * Inicializa nesta classe a interface livroService
	 */
	@Autowired
	private LivroService livroService;
	
	/**
	 * Inicializa nesta classe a interface anaisCongressoService
	 */
	@Autowired
	private AnaisCongressoService anaisCongressoService;
	
	/**
	 * Inicializa nesta classe a interface revistaService
	 */
	@Autowired
	private RevistaService revistaService;
	
	/**
	 * Inicializa nesta classe a interface midiasEletronicasService
	 */
	@Autowired
	private MidiasEletronicasService midiasEletronicasService;
	
	/**
	 * Inicializa nesta classe a interface trabalhosConclusaoService
	 */
	@Autowired
	private TrabalhosConclusaoService trabalhosConclusaoService;

	/**
	 * rota [/emprestimos], e retorna 
	 * uma view com o modelo definido [carregar todos os emprestimos abertos].
	 * 
	 * @param model - modelo de rota de view.
	 * @param principal - rota principal definida pelo parametro passado.
	 * @throws IOException - tratamento de exceção.
	 */
	@RequestMapping(value = "/emprestimos")
	public ModelAndView listEmprestimo(ModelAndView model, Principal principal) throws IOException {
		List<Emprestimo> listEmprestimo = emprestimoService.getAllEmprestimos();
		model = principal.userDetail(model, "emprestimos/index");
		model.addObject("listEmprestimo", listEmprestimo);
		return model;
	}
	
	/**
	 * Metodo de retorno de view, rota: [/newEmprestimo]. 
	 * Criar um novo emprestimo.
	 * Lista todos os tipos de itens cadastrados que podem ser emprestados.
	 * Lista com todos os alunos cadastrados.
	 *
	 */
	@RequestMapping(value = "/newEmprestimo", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		List<Livro> livros = livroService.getAllLivros();
		List<Revista> revistas = revistaService.getAllRevistas();
		List<TrabalhosConclusao> trabalhosConclusao = trabalhosConclusaoService.getAllTrabalhosConclusaos();
		List<AnaisCongresso> anaisCongresso = anaisCongressoService.getAllAnaisCongressos();
		List<MidiasEletronicas> midiasEletronicas = midiasEletronicasService.getAllMidiasEletronicass();
		List<Aluno> alunos = alunosService.getAllAlunos();
				
		Emprestimo emprestimo = new Emprestimo();
		model = principal.userDetail(model, "emprestimos/form");
		
		model.addObject("alunos", alunos);
		model.addObject("emprestimo", emprestimo);
		model.addObject("livros", livros);
		model.addObject("revistas", revistas);
		model.addObject("trabalhosConclusao", trabalhosConclusao);
		model.addObject("anaisCongresso", anaisCongresso);
		model.addObject("midiasEletronicas", midiasEletronicas);
		return model;
	}

	/**
	 * rota: [/saveEmprestimo].
	 * Salva dados referente a um emprestimo. 
	 * @param emprestimo.getId - Id do emprestimo como parametro de comparacao, 
	 * para saber se vai add um novo emprestimo ou atualizar
	 */
	@RequestMapping(value = "/saveEmprestimo", method = RequestMethod.POST)
	public ModelAndView saveEmprestimo(@ModelAttribute Emprestimo emprestimo) {
		if (emprestimo.getId() == 0) { 
			System.out.println(emprestimo.toString());
			emprestimoService.addEmprestimo(emprestimo);
		} else {
			emprestimoService.updateEmprestimo(emprestimo);
		}
		return new ModelAndView("redirect:/emprestimos");
	}

	/**
	 * rota: /deleteEmprestimo
	 * Deleta um emprestimo pelo id inserido
	 * 
	 * @param id_Emprestimo
	 * @return view atualizada de emprestimos.
	 */
	@RequestMapping(value = "/deleteEmprestimo", method = RequestMethod.GET)
	public ModelAndView deleteEmprestimo(HttpServletRequest request) {
		int emprestimoId = Integer.parseInt(request.getParameter("id"));
		emprestimoService.deleteEmprestimo(emprestimoId);
		return new ModelAndView("redirect:/emprestimos");
	}

	/**
	 * rota: /editEmprestimo
	 * Carrega um emprestimo pelo id passado e então carrega seus dados em uma view para ser alterado.
	 *
	 * @param id_Emprestimo
	 * @return
	 */
	@RequestMapping(value = "/editEmprestimo", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int emprestimoId = Integer.parseInt(request.getParameter("id"));
		Emprestimo emprestimo = emprestimoService.getEmprestimo(emprestimoId);		
		Principal principal = new Principal();		
		ModelAndView model = new ModelAndView();		
		model = principal.userDetail(model, "emprestimos/form");
		model.addObject("emprestimo", emprestimo);
		return model;
	}

}