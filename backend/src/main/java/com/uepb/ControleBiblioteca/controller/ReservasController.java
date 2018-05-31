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

import com.uepb.ControleBiblioteca.entities.Reservas;
import com.uepb.ControleBiblioteca.exception.ReservasException;
import com.uepb.ControleBiblioteca.repository.ReservasRepository;
import com.uepb.ControleBiblioteca.services.IReservasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reservas")
@Api(value = "API Rest - Reservas Endpoint")
public class ReservasController {

	private static final Logger LOG = LoggerFactory.getLogger(ReservasController.class);

	@Autowired
	private IReservasService reservasService;

	public ReservasController(IReservasService reservasService) {
		this.reservasService = reservasService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Reservas> findAll() {
		LOG.warn("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.reservasService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Reservas findOne(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.reservasService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Reservas create(@RequestBody Reservas reservas) {
		LOG.error("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.reservasService.create(reservas);
	}

	// Update a Reservas
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Reservas update(@PathVariable(value = "id") Integer id, @RequestBody Reservas reservasDetails) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.reservasService.update(reservasDetails, id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Integer id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		this.reservasService.remove(id);
	}

}
