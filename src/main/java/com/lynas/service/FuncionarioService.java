package com.lynas.service;

import java.util.List;

import com.lynas.model.Funcionario;

public interface FuncionarioService {
	
	public void addFuncionario(Funcionario funcionario);

	public List<Funcionario> getAllFuncionarios();

	public void deleteFuncionario(Integer funcionarioId);

	public Funcionario getFuncionario(int funcionarioid);

	public Funcionario updateFuncionario(Funcionario funcionario);
}
