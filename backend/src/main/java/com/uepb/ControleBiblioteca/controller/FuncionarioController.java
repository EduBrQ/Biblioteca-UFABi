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

import com.uepb.ControleBiblioteca.entities.Funcionario;
import com.uepb.ControleBiblioteca.exception.FuncionarioException;
import com.uepb.ControleBiblioteca.repository.FuncionarioRepository;
import com.uepb.ControleBiblioteca.services.IFuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/funcionarios")
@Api(value = "API Rest - Funcionario Endpoint")
public class FuncionarioController {

	private static final Logger LOG = LoggerFactory.getLogger(FuncionarioController.class);

	@Autowired
	private IFuncionarioService funcionarioService;

	public FuncionarioController(IFuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Funcionario> findAll() {
		LOG.warn("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.funcionarioService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Funcionario findOne(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.funcionarioService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Funcionario create(@RequestBody Funcionario funcionario) {
		LOG.error("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.funcionarioService.create(funcionario);
	}

	// Update a Funcionario
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Funcionario update(@PathVariable(value = "id") Integer id, @RequestBody Funcionario funcionarioDetails) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.funcionarioService.update(funcionarioDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		this.funcionarioService.remove(id);
	}

}
