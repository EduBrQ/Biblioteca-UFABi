package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.LivrosController;
import com.uepb.ControleBiblioteca.entities.Livros;
import com.uepb.ControleBiblioteca.exception.LivrosException;
import com.uepb.ControleBiblioteca.repository.LivrosRepository;

@Service
public class LivrosService implements ILivrosService {

	private static final Logger LOG = LoggerFactory.getLogger(LivrosController.class);

	@Autowired
	private LivrosRepository livrosRepository;

	public LivrosService(LivrosRepository livrosRepository) {
		this.livrosRepository = livrosRepository;
	}

	@Override
	public List<Livros> findAll() {
		return this.livrosRepository.findAll();
	}

	@Override
	public Livros create(Livros livros) {
		return this.livrosRepository.save(livros);
	}

	@Override
	public Livros findOne(Integer id) {
		Optional<Livros> todoResult = livrosRepository.findById(id);
		return todoResult.orElseThrow(() -> new LivrosException("Error"));
	}

	@Override
	public void remove(Integer id) {
		if (this.livrosRepository.existsById(id)) {
			this.livrosRepository.deleteById(id);
		}
	}

	@Transactional(readOnly = true, rollbackFor = { LivrosException.class })
	@Override
	public Livros findById(Integer id) throws LivrosException {
		LOG.debug("Finding a to-do entry with id: {}", id);

		Livros found = livrosRepository.findOne(id);
		LOG.debug("Found to-do entry: {}", found);

		if (found == null) {
			throw new LivrosException("No to-entry found with id: " + id);
		}

		return found;
	}

	@Override
	public Livros update(Livros livrosDetails, Integer Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		Livros livros = livrosRepository.findById(Id).orElseThrow(() -> new LivrosException("Error"));
		
		livros.setAnoPublicacao(livros.getAnoPublicacao());
		livros.setAreaConhecimento(livros.getAreaConhecimento());
		livros.setAutores(livros.getAutores());
		livros.setEdicao(livros.getEdicao());
		livros.setEditora(livros.getEditora());
		livros.setISBN(livros.getISBN());
		livros.setNumeroPaginas(livros.getNumeroPaginas());
		livros.setTipoTema(livros.getTipoTema());
		livros.setTitulo(livros.getTitulo());

		Livros updatedLivros = livrosRepository.save(livros);

		return updatedLivros;
	}
}
