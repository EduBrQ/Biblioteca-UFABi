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

import com.uepb.ControleBiblioteca.entities.Revistas;
import com.uepb.ControleBiblioteca.services.IRevistasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/revistas")
@Api(value = "API Rest - Revistas Endpoint")
public class RevistasController {

	private static final Logger LOG = LoggerFactory.getLogger(RevistasController.class);

	@Autowired
	private IRevistasService revistasService;

	public RevistasController(IRevistasService revistasService) {
		this.revistasService = revistasService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Revistas> findAll() {
		LOG.info("busca todos os registro no banco...");
		return this.revistasService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Optional<Revistas> findOne(@PathVariable("id") Long id) {
		LOG.info("busca um registro no banco...");
		return this.revistasService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Revistas create(@RequestBody Revistas revistas) {
		LOG.info("cria um registro no banco...");
		return this.revistasService.create(revistas);
	}

	// Update a Revistas
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Revistas update(@PathVariable(value = "id") Long Id, @RequestBody Revistas revistasDetails) {
		LOG.info("edita um registro no banco...");
		return this.revistasService.update(revistasDetails, Id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Long id) {
		LOG.info("remove um registro no banco...");
		this.revistasService.remove(id);
	}

}
