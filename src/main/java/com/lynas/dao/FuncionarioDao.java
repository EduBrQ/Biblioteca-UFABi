package com.lynas.dao;

import java.util.List;
import com.lynas.model.Funcionario;

public interface FuncionarioDao {

	public void addFuncionario(Funcionario funcionario);

	public List<Funcionario> getAllFuncionarios();

	public void deleteFuncionario(Integer funcionarioId);

	public Funcionario updateFuncionario(Funcionario funcionario);

	public Funcionario getFuncionario(int funcionarioid);
}
