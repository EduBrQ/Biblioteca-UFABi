package com.uepb.ControleBiblioteca.services;

import java.util.List;

import com.uepb.ControleBiblioteca.entities.Livros;
import com.uepb.ControleBiblioteca.exception.LivrosException;

public interface ILivrosService {
	
	List<Livros> findAll();
	Livros findOne(Integer id);
	Livros create(Livros livros);
	Livros update(Livros livros, Integer Id);
	public void remove(Integer id);
    public Livros findById(Integer id) throws LivrosException;

}
