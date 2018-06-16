package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uepb.ControleBiblioteca.controller.RevistasController;
import com.uepb.ControleBiblioteca.entities.Revistas;
import com.uepb.ControleBiblioteca.exception.RevistasException;
import com.uepb.ControleBiblioteca.repository.RevistasRepository;

@Service
public class RevistasService implements IRevistasService {

	private static final Logger LOG = LoggerFactory.getLogger(RevistasController.class);

	@Autowired
	private RevistasRepository revistasRepository;

	public RevistasService(RevistasRepository revistasRepository) {
		this.revistasRepository = revistasRepository;
	}

	@Override
	public List<Revistas> findAll() {
		return this.revistasRepository.findAll();
	}

	@Override
	public Revistas create(Revistas revistas) {
		return this.revistasRepository.save(revistas);
	}

	@Override
	public Optional<Revistas> findOne(Long id) {
		return this.revistasRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		if (this.revistasRepository.existsById(id)) {
			this.revistasRepository.deleteById(id);
		}
	}

	

	@Override
	public Revistas update(Revistas revistasDetails, Long Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		Revistas revistas = revistasRepository.findById(Id).orElseThrow(() -> new RevistasException("Error"));
		
		revistas.setTitulo(revistasDetails.getTitulo());
		revistas.setEdicao(revistasDetails.getEdicao());
		revistas.setDataPublicacao(revistasDetails.getDataPublicacao());

		Revistas updatedRevistas = revistasRepository.save(revistas);

		return updatedRevistas;
	}
}
