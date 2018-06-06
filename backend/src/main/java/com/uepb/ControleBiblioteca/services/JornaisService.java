package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.JornaisController;
import com.uepb.ControleBiblioteca.entities.Jornais;
import com.uepb.ControleBiblioteca.exception.JornaisException;
import com.uepb.ControleBiblioteca.repository.JornaisRepository;

@Service
public class JornaisService implements IJornaisService {

	private static final Logger LOG = LoggerFactory.getLogger(JornaisController.class);

	@Autowired
	private JornaisRepository jornaisRepository;

	public JornaisService(JornaisRepository jornaisRepository) {
		this.jornaisRepository = jornaisRepository;
	}

	@Override
	public List<Jornais> findAll() {
		return this.jornaisRepository.findAll();
	}

	@Override
	public Jornais create(Jornais jornais) {
		return this.jornaisRepository.save(jornais);
	}

	@Override
	public Jornais findOne(Integer id) {
		Optional<Jornais> todoResult = jornaisRepository.findById(id);
		return todoResult.orElseThrow(() -> new JornaisException("Error"));
	}

	@Override
	public void remove(Integer id) {
		if (this.jornaisRepository.existsById(id)) {
			this.jornaisRepository.deleteById(id);
		}
	}

	@Transactional(readOnly = true, rollbackFor = { JornaisException.class })
	@Override
	public Jornais findById(Integer id) throws JornaisException {
		LOG.debug("Finding a to-do entry with id: {}", id);

		Jornais found = jornaisRepository.findOne(id);
		LOG.debug("Found to-do entry: {}", found);

		if (found == null) {
			throw new JornaisException("No to-entry found with id: " + id);
		}

		return found;
	}

	@Override
	public Jornais update(Jornais jornaisDetails, Integer Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		Jornais jornais = jornaisRepository.findById(Id).orElseThrow(() -> new JornaisException("Error"));
		
		jornais.setDataPublicacao(jornais.getDataPublicacao());
		jornais.setEdicao(jornais.getEdicao());
		jornais.setTitulo(jornais.getTitulo());

		Jornais updatedJornais = jornaisRepository.save(jornais);

		return updatedJornais;
	}
}
