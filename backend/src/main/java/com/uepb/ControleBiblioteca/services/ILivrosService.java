package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.Livros;
import com.uepb.ControleBiblioteca.exception.LivrosException;

public interface ILivrosService {

	List<Livros> findAll();
	Optional<Livros> findOne(Long id);
	Livros create(Livros livros);
	Livros update(Livros livros, Long Id);
	public void remove(Long id);
//    public Livros findById(Long id) throws LivrosException;

}
