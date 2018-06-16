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

import com.uepb.ControleBiblioteca.entities.Jornais;
import com.uepb.ControleBiblioteca.services.IJornaisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/jornais")
@Api(value = "API Rest - Jornais Endpoint")
public class JornaisController {

	private static final Logger LOG = LoggerFactory.getLogger(JornaisController.class);

	@Autowired
	private IJornaisService jornaisService;

	public JornaisController(IJornaisService jornaisService) {
		this.jornaisService = jornaisService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Jornais> findAll() {
		LOG.info("busca todos registros no banco...");
		return this.jornaisService.findAll();
	}


	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Optional<Jornais> findOne(@PathVariable("id") Long id) {
		LOG.info("busca um registro no banco...");
		return this.jornaisService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Jornais create(@RequestBody Jornais jornais) {
		LOG.info("criou um registro no banco...");
		return this.jornaisService.create(jornais);
	}

	// Update a Jornais
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Jornais update(@PathVariable(value = "id") Long id, @RequestBody Jornais jornaisDetails) {
		LOG.info("editou um registro no banco...");
		return this.jornaisService.update(jornaisDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Long id) {
		LOG.info("remove um registro no banco...");
		this.jornaisService.remove(id);
	}

}
