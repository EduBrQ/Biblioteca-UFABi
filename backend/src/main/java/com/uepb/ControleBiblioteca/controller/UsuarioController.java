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

import com.uepb.ControleBiblioteca.entities.Usuarios;
import com.uepb.ControleBiblioteca.exception.UsuariosException;
import com.uepb.ControleBiblioteca.repository.UsuariosRepository;
import com.uepb.ControleBiblioteca.services.IUsuariosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(value = "API Rest - Usuarios Endpoint")
public class UsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private IUsuariosService usuariosService;

	public UsuariosController(IUsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Usuarios> findAll() {
		LOG.warn("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.usuariosService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Usuarios findOne(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.usuariosService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Usuarios create(@RequestBody Usuarios usuarios) {
		LOG.error("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.usuariosService.create(usuarios);
	}

	// Update a Usuarios
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Usuarios update(@PathVariable(value = "id") Integer id, @RequestBody Usuarios usuariosDetails) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.usuariosService.update(usuariosDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		this.usuariosService.remove(id);
	}

}
