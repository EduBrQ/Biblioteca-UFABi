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

import com.uepb.ControleBiblioteca.entities.Usuario;
import com.uepb.ControleBiblioteca.exception.UsuarioException;
import com.uepb.ControleBiblioteca.repository.UsuarioRepository;
import com.uepb.ControleBiblioteca.services.IUsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(value = "API Rest - Usuario Endpoint")
public class UsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private IUsuarioService usuariosService;

	public UsuarioController(IUsuarioService usuariosService) {
		this.usuariosService = usuariosService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Usuario> findAll() {
		LOG.warn("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.usuariosService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Usuario findOne(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.usuariosService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Usuario create(@RequestBody Usuario usuarios) {
		LOG.error("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.usuariosService.create(usuarios);
	}

	// Update a Usuario
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Usuario update(@PathVariable(value = "id") Integer id, @RequestBody Usuario usuariosDetails) {
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
