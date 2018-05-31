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

import com.uepb.ControleBiblioteca.entities.Emprestimos;
import com.uepb.ControleBiblioteca.exception.EmprestimosException;
import com.uepb.ControleBiblioteca.repository.EmprestimosRepository;
import com.uepb.ControleBiblioteca.services.IEmprestimosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/emprestimos")
@Api(value = "API Rest - Emprestimos Endpoint")
public class EmprestimosController {

	private static final Logger LOG = LoggerFactory.getLogger(EmprestimosController.class);

	@Autowired
	private IEmprestimosService emprestimosService;

	public EmprestimosController(IEmprestimosService emprestimosService) {
		this.emprestimosService = emprestimosService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Emprestimos> findAll() {
		LOG.warn("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.emprestimosService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Emprestimos findOne(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.emprestimosService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Emprestimos create(@RequestBody Emprestimos emprestimos) {
		LOG.error("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.emprestimosService.create(emprestimos);
	}

	// Update a Emprestimos
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Emprestimos update(@PathVariable(value = "id") Integer id, @RequestBody Emprestimos emprestimosDetails) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.emprestimosService.update(emprestimosDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		this.emprestimosService.remove(id);
	}

}
