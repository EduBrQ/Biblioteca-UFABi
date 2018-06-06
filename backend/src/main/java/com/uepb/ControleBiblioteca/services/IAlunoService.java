package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.Aluno;
import com.uepb.ControleBiblioteca.exception.AlunoException;

public interface IAlunoService {

	List<Aluno> findAll();
	Optional<Aluno> findOne(Long id);
	Aluno create(Aluno aluno);
	Aluno update(Aluno aluno, Long Id);
	public void remove(Long id);
//    public Aluno findById(Long id) throws AlunoException;

}
