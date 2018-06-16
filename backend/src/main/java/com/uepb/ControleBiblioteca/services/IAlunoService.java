package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.Aluno;

public interface IAlunoService {

	List<Aluno> findAll();
	Optional<Aluno> findOne(Long id);
	Aluno create(Aluno aluno);
	Aluno update(Aluno aluno, Long Id);
	public void remove(Long id);

}
