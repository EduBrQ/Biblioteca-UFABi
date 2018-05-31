package com.uepb.ControleBiblioteca.services;

import java.util.List;

import com.uepb.ControleBiblioteca.entities.Aluno;
import com.uepb.ControleBiblioteca.exception.AlunoException;

public interface IAlunoService {
	
	List<Aluno> findAll();
	Aluno findOne(Integer id);
	Aluno create(Aluno aluno);
	Aluno update(Aluno aluno, Integer Id);
	public void remove(Integer id);
    public Aluno findById(Integer id) throws AlunoException;

}
