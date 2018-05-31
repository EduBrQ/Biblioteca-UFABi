package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.AnaisDeCongressoController;
import com.uepb.ControleBiblioteca.entities.AnaisDeCongresso;
import com.uepb.ControleBiblioteca.exception.AnaisDeCongressoException;
import com.uepb.ControleBiblioteca.repository.AnaisDeCongressoRepository;

@Service
public class AnaisDeCongressoService implements IAnaisDeCongressoService {

	private static final Logger LOG = LoggerFactory.getLogger(AnaisDeCongressoController.class);

	@Autowired
	private AnaisDeCongressoRepository anaisDeCongressoRepository;

	public AnaisDeCongressoService(AnaisDeCongressoRepository anaisDeCongressoRepository) {
		this.anaisDeCongressoRepository = anaisDeCongressoRepository;
	}

	@Override
	public List<AnaisDeCongresso> findAll() {
		return this.anaisDeCongressoRepository.findAll();
	}

	@Override
	public AnaisDeCongresso create(AnaisDeCongresso anaisDeCongresso) {
		return this.anaisDeCongressoRepository.save(anaisDeCongresso);
	}

	@Override
	public AnaisDeCongresso findOne(Integer id) {
		Optional<AnaisDeCongresso> todoResult = anaisDeCongressoRepository.findById(id);
		return todoResult.orElseThrow(() -> new AnaisDeCongressoException("Error"));
	}

	@Override
	public void remove(Integer id) {
		if (this.anaisDeCongressoRepository.existsById(id)) {
			this.anaisDeCongressoRepository.deleteById(id);
		}
	}

	@Transactional(readOnly = true, rollbackFor = { AnaisDeCongressoException.class })
	@Override
	public AnaisDeCongresso findById(Integer id) throws AnaisDeCongressoException {
		LOG.debug("Finding a to-do entry with id: {}", id);

		AnaisDeCongresso found = anaisDeCongressoRepository.findOne(id);
		LOG.debug("Found to-do entry: {}", found);

		if (found == null) {
			throw new AnaisDeCongressoException("No to-entry found with id: " + id);
		}

		return found;
	}

	@Override
	public AnaisDeCongresso update(AnaisDeCongresso anaisDeCongressoDetails, Integer Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		AnaisDeCongresso anaisDeCongresso = anaisDeCongressoRepository.findById(Id).orElseThrow(() -> new AnaisDeCongressoException("Error"));

		anaisDeCongresso.setAnoPublicacao(anaisDeCongressoDetails.getAnoPublicacao());

		anaisDeCongresso.setAutores(anaisDeCongressoDetails.getAutores());
		
		anaisDeCongresso.setEdicao(anaisDeCongressoDetails.getEdicao());
		
		anaisDeCongresso.setLocal(anaisDeCongressoDetails.getLocal());
		
		anaisDeCongresso.setNomeCongresso(anaisDeCongressoDetails.getNomeCongresso());
		
		anaisDeCongresso.setOrientadores(anaisDeCongressoDetails.getOrientadores());
		
		anaisDeCongresso.setTipoAnal(anaisDeCongressoDetails.getTipoAnal());

		AnaisDeCongresso updatedAnaisDeCongresso = anaisDeCongressoRepository.save(anaisDeCongresso);

		return updatedAnaisDeCongresso;
	}
}
