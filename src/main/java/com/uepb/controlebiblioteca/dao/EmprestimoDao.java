package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.Emprestimo;

/**
 * Interface que define os metodos que podem ser utilizados implementando a mesma.
 * @author Eduardo Borba
 *
 */
public interface EmprestimoDao {

	public void addEmprestimo(Emprestimo emprestimo);

	public List<Emprestimo> getAllEmprestimos();

	public void deleteEmprestimo(Integer emprestimoId);

	public Emprestimo updateEmprestimo(Emprestimo emprestimo);

	public Emprestimo getEmprestimo(int emprestimoid);
}
