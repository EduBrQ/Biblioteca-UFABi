package com.uepb.controlebiblioteca.service;

import java.util.List;

import com.uepb.controlebiblioteca.model.Aluno;

public interface AlunoService {
	
	public void addAluno(Aluno aluno);

	public List<Aluno> getAllAlunos();

	public void deleteAluno(Integer alunoId);

	public Aluno getAluno(int alunoId);

	public Aluno updateAluno(Aluno aluno);
}
