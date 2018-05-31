package com.uepb.ControleBiblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uepb.ControleBiblioteca.entities.Livros;
import com.uepb.ControleBiblioteca.exception.LivrosException;
import com.uepb.ControleBiblioteca.repository.LivrosRepository;
import com.uepb.ControleBiblioteca.services.ILivrosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/livros")
@Api(value = "API Rest - Livros Endpoint")
public class LivrosController {

	private static final Logger LOG = LoggerFactory.getLogger(LivrosController.class);

	@Autowired
	private ILivrosService livrosService;

	public LivrosController(ILivrosService livrosService) {
		this.livrosService = livrosService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Livros> findAll() {
		LOG.warn("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.livrosService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Livros findOne(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.livrosService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Livros create(@RequestBody Livros livros) {
		LOG.error("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.livrosService.create(livros);
	}

	// Update a Livros
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Livros update(@PathVariable(value = "id") Integer id, @RequestBody Livros livrosDetails) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.livrosService.update(livrosDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		this.livrosService.remove(id);
	}

}
