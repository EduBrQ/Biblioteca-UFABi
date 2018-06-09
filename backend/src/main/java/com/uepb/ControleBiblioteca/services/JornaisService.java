package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.JornaisController;
import com.uepb.ControleBiblioteca.entities.Curso;
import com.uepb.ControleBiblioteca.entities.Jornais;
import com.uepb.ControleBiblioteca.entities.Task;
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
	public Optional<Jornais> findOne(Long id) {
		return this.jornaisRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		if (this.jornaisRepository.existsById(id)) {
			this.jornaisRepository.deleteById(id);
		}
	}

	

	@Override
	public Jornais update(Jornais jornaisDetails, Long Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		Jornais jornais = jornaisRepository.findById(Id).orElseThrow(() -> new JornaisException("Error"));
		
		jornais.setTitulo(jornaisDetails.getTitulo());
		jornais.setEdicao(jornaisDetails.getEdicao());
		jornais.setDataPublicacao(jornaisDetails.getDataPublicacao());

		Jornais updatedJornais = jornaisRepository.save(jornais);

		return updatedJornais;
	}
}
