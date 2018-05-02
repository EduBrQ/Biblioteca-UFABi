package com.uepb.controlebiblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.controlebiblioteca.dao.FuncionarioDao;
import com.uepb.controlebiblioteca.model.Funcionario;
import com.uepb.controlebiblioteca.service.FuncionarioService;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao FuncionarioDao;

	@Override
	@Transactional
	public void addFuncionario(Funcionario funcionario) {
		FuncionarioDao.addFuncionario(funcionario);
	}

	@Override
	@Transactional
	public List<Funcionario> getAllFuncionarios() {
		return FuncionarioDao.getAllFuncionarios();
	}

	@Override
	@Transactional
	public void deleteFuncionario(Integer funcionarioId) {
		FuncionarioDao.deleteFuncionario(funcionarioId);
	}

	public Funcionario getFuncionario(int empid) {
		return FuncionarioDao.getFuncionario(empid);
	}

	public Funcionario updateFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return FuncionarioDao.updateFuncionario(funcionario);
	}

	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.FuncionarioDao = funcionarioDao;
	}

}
