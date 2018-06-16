package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.Livros;

public interface ILivrosService {

	List<Livros> findAll();
	Optional<Livros> findOne(Long id);
	Livros create(Livros livros);
	Livros update(Livros livros, Long Id);
	public void remove(Long id);

}
