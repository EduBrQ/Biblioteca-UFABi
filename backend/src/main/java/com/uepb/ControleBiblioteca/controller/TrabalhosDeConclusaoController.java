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

import com.uepb.ControleBiblioteca.entities.TrabalhosDeConclusao;
import com.uepb.ControleBiblioteca.services.ITrabalhosDeConclusaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/trabalhosDeConclusao")
@Api(value = "API Rest - TrabalhosDeConclusao Endpoint")
public class TrabalhosDeConclusaoController {

	private static final Logger LOG = LoggerFactory.getLogger(TrabalhosDeConclusaoController.class);

	@Autowired
	private ITrabalhosDeConclusaoService trabalhosDeConclusaoService;

	public TrabalhosDeConclusaoController(ITrabalhosDeConclusaoService trabalhosDeConclusaoService) {
		this.trabalhosDeConclusaoService = trabalhosDeConclusaoService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<TrabalhosDeConclusao> findAll() {
		LOG.info("busca todos os registro no banco...");
		return this.trabalhosDeConclusaoService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Optional<TrabalhosDeConclusao> findOne(@PathVariable("id") Long id) {
		LOG.info("busca um registro no banco...");
		return this.trabalhosDeConclusaoService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public TrabalhosDeConclusao create(@RequestBody TrabalhosDeConclusao trabalhosDeConclusao) {
		LOG.info("cria um registro no banco...");
		return this.trabalhosDeConclusaoService.create(trabalhosDeConclusao);
	}

	// Update a TrabalhosDeConclusao
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public TrabalhosDeConclusao update(@PathVariable(value = "id") Long id, @RequestBody TrabalhosDeConclusao trabalhosDeConclusaoDetails) {
		LOG.info("edita um registro no banco...");
		return this.trabalhosDeConclusaoService.update(trabalhosDeConclusaoDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Long id) {
		LOG.info("remove um registro no banco...");
		this.trabalhosDeConclusaoService.remove(id);
	}

}
