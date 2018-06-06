package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public TrabalhosDeConclusao findOne(Integer id) {
		Optional<TrabalhosDeConclusao> todoResult = trabalhosDeConclusaoRepository.findById(id);
		return todoResult.orElseThrow(() -> new TrabalhosDeConclusaoException("Error"));
	}

	@Override
	public void remove(Integer id) {
		if (this.trabalhosDeConclusaoRepository.existsById(id)) {
			this.trabalhosDeConclusaoRepository.deleteById(id);
		}
	}

	@Transactional(readOnly = true, rollbackFor = { TrabalhosDeConclusaoException.class })
	@Override
	public TrabalhosDeConclusao findById(Integer id) throws TrabalhosDeConclusaoException {
		LOG.debug("Finding a to-do entry with id: {}", id);

		TrabalhosDeConclusao found = trabalhosDeConclusaoRepository.findOne(id);
		LOG.debug("Found to-do entry: {}", found);

		if (found == null) {
			throw new TrabalhosDeConclusaoException("No to-entry found with id: " + id);
		}

		return found;
	}

	@Override
	public TrabalhosDeConclusao update(TrabalhosDeConclusao trabalhosDeConclusaoDetails, Integer Id) {

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
