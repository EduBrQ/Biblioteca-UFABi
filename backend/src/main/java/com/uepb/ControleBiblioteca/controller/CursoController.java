package com.uepb.ControleBiblioteca.controller;

import java.util.List;
import java.util.Optional;

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

import com.uepb.ControleBiblioteca.entities.Curso;
import com.uepb.ControleBiblioteca.exception.CursoException;
import com.uepb.ControleBiblioteca.repository.CursoRepository;
import com.uepb.ControleBiblioteca.services.ICursoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cursos")
@Api(value = "API Rest - Curso Endpoint")
public class CursoController {

	private static final Logger LOG = LoggerFactory.getLogger(CursoController.class);

	@Autowired
	private ICursoService cursoService;

	public CursoController(ICursoService cursoService) {
		this.cursoService = cursoService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Curso> findAll() {
		LOG.warn("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.cursoService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Optional<Curso> findOne(@PathVariable("id") Long id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.cursoService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Curso create(@RequestBody Curso curso) {
		LOG.error("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.cursoService.create(curso);
	}

	// Update a Curso
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Curso update(@PathVariable(value = "id") Long id, @RequestBody Curso cursoDetails) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.cursoService.update(cursoDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Long id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		this.cursoService.remove(id);
	}

}
