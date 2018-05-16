package com.uepb.controlebiblioteca.service;

import java.util.List;

import com.uepb.controlebiblioteca.model.Emprestimo;

public interface EmprestimoService {
	
	public void addEmprestimo(Emprestimo emprestimo);

	public List<Emprestimo> getAllEmprestimos();

	public void deleteEmprestimo(Integer emprestimoId);

	public Emprestimo getEmprestimo(int emprestimoId);

	public Emprestimo updateEmprestimo(Emprestimo emprestimo);
}
