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
import com.uepb.controlebiblioteca.model.Reserva;
import com.uepb.controlebiblioteca.model.Livro;
import com.uepb.controlebiblioteca.model.MidiasEletronicas;
import com.uepb.controlebiblioteca.model.Revista;
import com.uepb.controlebiblioteca.model.TrabalhosConclusao;
import com.uepb.controlebiblioteca.service.AlunoService;
import com.uepb.controlebiblioteca.service.AnaisCongressoService;
import com.uepb.controlebiblioteca.service.ReservaService;
import com.uepb.controlebiblioteca.service.LivroService;
import com.uepb.controlebiblioteca.service.MidiasEletronicasService;
import com.uepb.controlebiblioteca.service.RevistaService;
import com.uepb.controlebiblioteca.service.TrabalhosConclusaoService;
import com.uepb.controlebiblioteca.util.Principal;

/**
 * ReservaController representa os serviços de controle de Reservas.
 * 
 * @author Eduardo Borba
 *
 */
@Controller
public class ReservaController {

	private static final Logger logger = Logger.getLogger(ReservaController.class);

	public ReservaController() {
		System.out.println("ReservaController()");
	}
	
	/**
	 * Inicializa nesta classe a interface alunosService
	 */
	@Autowired
	private AlunoService alunosService;
	
	/**
	 * Inicializa nesta classe a interface reservaService
	 */
	@Autowired
	private ReservaService reservaService;
	
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
	 * rota [/reservas], e retorna 
	 * uma view com o modelo definido [carregar todos os reservas abertos].
	 * 
	 * @param model - modelo de rota de view.
	 * @param principal - rota principal definida pelo parametro passado.
	 * @throws IOException - tratamento de exceção.
	 */
	@RequestMapping(value = "/reservas")
	public ModelAndView listReserva(ModelAndView model, Principal principal) throws IOException {
		List<Reserva> listReserva = reservaService.getAllReservas();
		model = principal.userDetail(model, "reservas/index");
		model.addObject("listReserva", listReserva);
		return model;
	}
	
	/**
	 * Metodo de retorno de view, rota: [/newReserva]. 
	 * Criar um novo reserva.
	 * Lista todos os tipos de itens cadastrados que podem ser emprestados.
	 * Lista com todos os alunos cadastrados.
	 *
	 */
	@RequestMapping(value = "/newReserva", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		List<Livro> livros = livroService.getAllLivros();
		List<Revista> revistas = revistaService.getAllRevistas();
		List<TrabalhosConclusao> trabalhosConclusao = trabalhosConclusaoService.getAllTrabalhosConclusaos();
		List<AnaisCongresso> anaisCongresso = anaisCongressoService.getAllAnaisCongressos();
		List<MidiasEletronicas> midiasEletronicas = midiasEletronicasService.getAllMidiasEletronicass();
		List<Aluno> alunos = alunosService.getAllAlunos();
				
		Reserva reserva = new Reserva();
		model = principal.userDetail(model, "reservas/form");
		
		model.addObject("alunos", alunos);
		model.addObject("reserva", reserva);
		model.addObject("livros", livros);
		model.addObject("revistas", revistas);
		model.addObject("trabalhosConclusao", trabalhosConclusao);
		model.addObject("anaisCongresso", anaisCongresso);
		model.addObject("midiasEletronicas", midiasEletronicas);
		return model;
	}

	/**
	 * rota: [/saveReserva].
	 * Salva dados referente a um reserva. 
	 * @param reserva.getId - Id do reserva como parametro de comparacao, 
	 * para saber se vai add um novo reserva ou atualizar
	 */
	@RequestMapping(value = "/saveReserva", method = RequestMethod.POST)
	public ModelAndView saveReserva(@ModelAttribute Reserva reserva) {
		if (reserva.getId() == 0) { 
			System.out.println(reserva.toString());
			reservaService.addReserva(reserva);
		} else {
			reservaService.updateReserva(reserva);
		}
		return new ModelAndView("redirect:/reservas");
	}

	/**
	 * rota: /deleteReserva
	 * Deleta um reserva pelo id inserido
	 * 
	 * @param id_Reserva
	 * @return view atualizada de reservas.
	 */
	@RequestMapping(value = "/deleteReserva", method = RequestMethod.GET)
	public ModelAndView deleteReserva(HttpServletRequest request) {
		int reservaId = Integer.parseInt(request.getParameter("id"));
		reservaService.deleteReserva(reservaId);
		return new ModelAndView("redirect:/reservas");
	}

	/**
	 * rota: /editReserva
	 * Carrega um reserva pelo id passado e então carrega seus dados em uma view para ser alterado.
	 *
	 * @param id_Reserva
	 * @return
	 */
	@RequestMapping(value = "/editReserva", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int reservaId = Integer.parseInt(request.getParameter("id"));
		Reserva reserva = reservaService.getReserva(reservaId);		
		Principal principal = new Principal();		
		ModelAndView model = new ModelAndView();		
		model = principal.userDetail(model, "reservas/form");
		model.addObject("reserva", reserva);
		return model;
	}

}