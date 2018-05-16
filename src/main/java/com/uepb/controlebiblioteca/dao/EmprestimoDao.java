package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.Emprestimo;

public interface EmprestimoDao {

	public void addEmprestimo(Emprestimo emprestimo);

	public List<Emprestimo> getAllEmprestimos();

	public void deleteEmprestimo(Integer emprestimoId);

	public Emprestimo updateEmprestimo(Emprestimo emprestimo);

	public Emprestimo getEmprestimo(int emprestimoid);
}
