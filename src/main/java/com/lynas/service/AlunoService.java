package com.lynas.service;

import java.util.List;

import com.lynas.model.Aluno;

public interface AlunoService {
	
	public void addAluno(Aluno aluno);

	public List<Aluno> getAllAlunos();

	public void deleteAluno(Integer alunoId);

	public Aluno getAluno(int alunoid);

	public Aluno updateAluno(Aluno aluno);
}
