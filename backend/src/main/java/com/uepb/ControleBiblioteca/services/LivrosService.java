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
import com.uepb.ControleBiblioteca.entities.Task;
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
	public Optional<Livros> findOne(Long id) {
		return this.livrosRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		if (this.livrosRepository.existsById(id)) {
			this.livrosRepository.deleteById(id);
		}
	}

	

	@Override
	public Livros update(Livros livrosDetails, Long Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		Livros livros = livrosRepository.findById(Id).orElseThrow(() -> new LivrosException("Error"));
		
		livros.setAnoPublicacao(livrosDetails.getAnoPublicacao());
		livros.setAreaConhecimento(livrosDetails.getAreaConhecimento());
		livros.setAutores(livrosDetails.getAutores());
		livros.setEdicao(livrosDetails.getEdicao());
		livros.setEditora(livrosDetails.getEditora());
		livros.setISBN(livrosDetails.getISBN());
		livros.setNumeroPaginas(livrosDetails.getNumeroPaginas());
		livros.setTipoTema(livrosDetails.getTipoTema());
		livros.setTitulo(livrosDetails.getTitulo());
		Livros updatedLivros = livrosRepository.save(livros);

		return updatedLivros;
	}
}
