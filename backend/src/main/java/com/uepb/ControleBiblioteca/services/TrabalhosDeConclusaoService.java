package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uepb.ControleBiblioteca.controller.TrabalhosDeConclusaoController;
import com.uepb.ControleBiblioteca.entities.TrabalhosDeConclusao;
import com.uepb.ControleBiblioteca.exception.TrabalhosDeConclusaoException;
import com.uepb.ControleBiblioteca.repository.TrabalhosDeConclusaoRepository;

@Service
public class TrabalhosDeConclusaoService implements ITrabalhosDeConclusaoService {

	private static final Logger LOG = LoggerFactory.getLogger(TrabalhosDeConclusaoController.class);

	@Autowired
	private TrabalhosDeConclusaoRepository trabalhosDeConclusaoRepository;

	public TrabalhosDeConclusaoService(TrabalhosDeConclusaoRepository trabalhosDeConclusaoRepository) {
		this.trabalhosDeConclusaoRepository = trabalhosDeConclusaoRepository;
	}

	@Override
	public List<TrabalhosDeConclusao> findAll() {
		return this.trabalhosDeConclusaoRepository.findAll();
	}

	@Override
	public TrabalhosDeConclusao create(TrabalhosDeConclusao trabalhosDeConclusao) {
		return this.trabalhosDeConclusaoRepository.save(trabalhosDeConclusao);
	}

	@Override
	public Optional<TrabalhosDeConclusao> findOne(Long id) {
		return this.trabalhosDeConclusaoRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		if (this.trabalhosDeConclusaoRepository.existsById(id)) {
			this.trabalhosDeConclusaoRepository.deleteById(id);
		}
	}

	
	@Override
	public TrabalhosDeConclusao update(TrabalhosDeConclusao trabalhosDeConclusaoDetails, Long Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		TrabalhosDeConclusao trabalhosDeConclusao = trabalhosDeConclusaoRepository.findById(Id).orElseThrow(() -> new TrabalhosDeConclusaoException("Error"));
		
		trabalhosDeConclusao.setAnoDefesa(trabalhosDeConclusao.getAnoDefesa());
		trabalhosDeConclusao.setAutores(trabalhosDeConclusao.getAutores());
		trabalhosDeConclusao.setEdicao(trabalhosDeConclusao.getEdicao());
		trabalhosDeConclusao.setLocal(trabalhosDeConclusao.getLocal());
		trabalhosDeConclusao.setOrientadores(trabalhosDeConclusao.getOrientadores());
		trabalhosDeConclusao.setTipoTcc(trabalhosDeConclusao.getTipoTcc());
		trabalhosDeConclusao.setTitulo(trabalhosDeConclusao.getTitulo());
		
		TrabalhosDeConclusao updatedTrabalhosDeConclusao = trabalhosDeConclusaoRepository.save(trabalhosDeConclusao);

		return updatedTrabalhosDeConclusao;
	}
}
