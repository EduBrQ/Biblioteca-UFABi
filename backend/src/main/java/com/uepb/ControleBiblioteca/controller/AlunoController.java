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

import com.uepb.ControleBiblioteca.entities.Aluno;
import com.uepb.ControleBiblioteca.services.IAlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/alunos")
@Api(value = "API Rest - Aluno Endpoint")
public class AlunoController {

	private static final Logger LOG = LoggerFactory.getLogger(AlunoController.class);

	@Autowired
	private IAlunoService alunoService;

	public AlunoController(IAlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public @ResponseBody List<Aluno> findAll() {
		LOG.info("Buscou todos os alunos...");
		return this.alunoService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Optional<Aluno> findOne(@PathVariable("id") Long id) {
		LOG.info("Troxe um aluno do banco...");
		return this.alunoService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Aluno create(@RequestBody Aluno aluno) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.alunoService.create(aluno);
	}

	// Update a Aluno
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Aluno update(@PathVariable(value = "id") Long id, @RequestBody Aluno alunoDetails) {
		LOG.info("Editou um aluno...");
		return this.alunoService.update(alunoDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Long id) {
		LOG.info("Removeu um aluno...");
		this.alunoService.remove(id);
	}

}
