package com.uepb.ControleBiblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uepb.ControleBiblioteca.entities.MidiasEletronicas;
import com.uepb.ControleBiblioteca.services.IMidiasEletronicasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/midiasEletronicas")
@Api(value = "API Rest - MidiasEletronicas Endpoint")
public class MidiasEletronicasController {

	private static final Logger LOG = LoggerFactory.getLogger(MidiasEletronicasController.class);

	@Autowired
	private IMidiasEletronicasService midiasEletronicasService;

	public MidiasEletronicasController(IMidiasEletronicasService midiasEletronicasService) {
		this.midiasEletronicasService = midiasEletronicasService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<MidiasEletronicas> findAll() {
		LOG.info("busca todos os registros no banco...");
		return this.midiasEletronicasService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Optional<MidiasEletronicas> findOne(@PathVariable("id") Long id) {
		LOG.info("busca um registro no banco...");
		return this.midiasEletronicasService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public MidiasEletronicas create(@RequestBody MidiasEletronicas midiasEletronicas) {
		LOG.info("cria um registro no banco...");
		return this.midiasEletronicasService.create(midiasEletronicas);
	}

	// Update a MidiasEletronicas
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public MidiasEletronicas update(@PathVariable(value = "id") Long id, @RequestBody MidiasEletronicas midiasEletronicasDetails) {
		LOG.info("edita um registro no banco...");
		return this.midiasEletronicasService.update(midiasEletronicasDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Long id) {
		LOG.info("remove um registro no banco...");
		this.midiasEletronicasService.remove(id);
	}

}
