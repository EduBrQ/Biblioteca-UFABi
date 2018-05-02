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

import com.uepb.controlebiblioteca.model.MidiasEletronicas;
import com.uepb.controlebiblioteca.service.MidiasEletronicasService;
import com.uepb.controlebiblioteca.util.Principal;

@Controller
public class MidiasEletronicasController {

	private static final Logger logger = Logger.getLogger(MidiasEletronicasController.class);

	public MidiasEletronicasController() {
		System.out.println("MidiasEletronicasController()");
	}

	@Autowired
	private MidiasEletronicasService midiasEletronicaService;

	@RequestMapping(value = "/midiasEletronicas")
	public ModelAndView listMidiasEletronicas(ModelAndView model, Principal principal) throws IOException {
		List<MidiasEletronicas> listMidiasEletronicas = midiasEletronicaService.getAllMidiasEletronicass();
		model = principal.userDetail(model, "midiasEletronicas/index");
		model.addObject("listMidiasEletronicas", listMidiasEletronicas);
		return model;
	}
	
	@RequestMapping(value = "/newMidiasEletronicas", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, Principal principal) {
		MidiasEletronicas midiasEletronicas = new MidiasEletronicas();
		model = principal.userDetail(model, "midiasEletronicas/form");
		model.addObject("midiasEletronicas", midiasEletronicas);
		return model;
	}

	@RequestMapping(value = "/saveMidiasEletronicas", method = RequestMethod.POST)
	public ModelAndView saveMidiasEletronicas(@ModelAttribute MidiasEletronicas midiasEletronicas) {
		if (midiasEletronicas.getId() == 0) { // if midiasEletronica id is 0 then creating the
			// midiasEletronica other updating the midiasEletronica
			midiasEletronicaService.addMidiasEletronicas(midiasEletronicas);
		} else {
			midiasEletronicaService.updateMidiasEletronicas(midiasEletronicas);
		}
		return new ModelAndView("redirect:/midiasEletronicas");
	}

	@RequestMapping(value = "/deleteMidiasEletronicas", method = RequestMethod.GET)
	public ModelAndView deleteMidiasEletronicas(HttpServletRequest request) {
		int midiasEletronicaId = Integer.parseInt(request.getParameter("id"));
		midiasEletronicaService.deleteMidiasEletronicas(midiasEletronicaId);
		return new ModelAndView("redirect:/midiasEletronicas");
	}

	@RequestMapping(value = "/editMidiasEletronicas", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int midiasEletronicaId = Integer.parseInt(request.getParameter("id"));
		MidiasEletronicas midiasEletronicas = midiasEletronicaService.getMidiasEletronicas(midiasEletronicaId);
		Principal principal = new Principal();
		ModelAndView model = new ModelAndView();
		model = principal.userDetail(model, "midiasEletronicas/form");	
		model.addObject("midiasEletronicas", midiasEletronicas);
		return model;
	}

}