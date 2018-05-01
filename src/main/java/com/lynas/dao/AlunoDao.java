package com.lynas.dao;

import java.util.List;
import com.lynas.model.Aluno;

public interface AlunoDao {

	public void addAluno(Aluno aluno);

	public List<Aluno> getAllAlunos();

	public void deleteAluno(Integer alunoId);

	public Aluno updateAluno(Aluno aluno);

	public Aluno getAluno(int alunoid);
}
