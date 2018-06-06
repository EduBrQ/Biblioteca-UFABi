package com.uepb.ControleBiblioteca.services;

import java.util.List;

import com.uepb.ControleBiblioteca.entities.Curso;
import com.uepb.ControleBiblioteca.exception.CursoException;

public interface ICursoService {
	
	List<Curso> findAll();
	Curso findOne(Integer id);
	Curso create(Curso curso);
	Curso update(Curso curso, Integer Id);
	public void remove(Integer id);
    public Curso findById(Integer id) throws CursoException;

}
