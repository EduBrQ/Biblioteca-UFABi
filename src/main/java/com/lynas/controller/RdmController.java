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

import com.lynas.model.Aluno;
import com.lynas.model.Rdm;
import com.lynas.service.AlunoService;
import com.lynas.service.RdmService;
import com.lynas.util.Principal;

@Controller
public class RdmController {

	private static final Logger logger = Logger.getLogger(RdmController.class);

	public RdmController() {
		System.out.println("RdmController()");
	}

	@Autowired
	private RdmService rdmService;
	
	@Autowired
	private AlunoService alunoService;

	@RequestMapping(value = "/rdms")
	public ModelAndView listRdm(ModelAndView model, Principal principal) throws IOException {
		List<Rdm> listRdm = rdmService.getAllRdms();
		model = principal.userDetail(model, "rdms/index");
		model.addObject("listRdm", listRdm);
		return model;
	}
	
	@RequestMapping(value = "/newRdm", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal, HttpServletRequest request) {
		int alunoId = Integer.parseInt(request.getParameter("id"));
		Aluno aluno = alunoService.getAluno(alunoId);	
		Rdm rdm = new Rdm();
		model = principal.userDetail(model, "rdms/form");
		model.addObject("aluno", aluno);
		model.addObject("rdm", rdm);
		return model;
	}

	@RequestMapping(value = "/saveRdm", method = RequestMethod.POST)
	public ModelAndView saveRdm(@ModelAttribute Rdm rdm) {
		if (rdm.getId() == 0) { // if rdm id is 0 then creating the
			// rdm other updating the rdm
			rdmService.addRdm(rdm);
		} else {
			rdmService.updateRdm(rdm);
		}
		return new ModelAndView("redirect:/rdms");
	}

	@RequestMapping(value = "/deleteRdm", method = RequestMethod.GET)
	public ModelAndView deleteRdm(HttpServletRequest request) {
		int rdmId = Integer.parseInt(request.getParameter("id"));
		rdmService.deleteRdm(rdmId);
		return new ModelAndView("redirect:/rdms");
	}

	@RequestMapping(value = "/editRdm", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int rdmId = Integer.parseInt(request.getParameter("id"));
		Rdm rdm = rdmService.getRdm(rdmId);		
		Principal principal = new Principal();		
		ModelAndView model = new ModelAndView();		
		model = principal.userDetail(model, "rdms/form");
		model.addObject("rdm", rdm);
		return model;
	}

}