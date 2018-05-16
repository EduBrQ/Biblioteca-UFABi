package com.uepb.controlebiblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.controlebiblioteca.dao.EmprestimoDao;
import com.uepb.controlebiblioteca.model.Emprestimo;
import com.uepb.controlebiblioteca.service.EmprestimoService;

@Service
@Transactional
public class EmprestimoServiceImpl implements EmprestimoService {

	@Autowired
	private EmprestimoDao EmprestimoDao;

	@Override
	@Transactional
	public void addEmprestimo(Emprestimo emprestimo) {
		EmprestimoDao.addEmprestimo(emprestimo);
	}

	@Override
	@Transactional
	public List<Emprestimo> getAllEmprestimos() {
		return EmprestimoDao.getAllEmprestimos();
	}

	@Override
	@Transactional
	public void deleteEmprestimo(Integer emprestimoId) {
		EmprestimoDao.deleteEmprestimo(emprestimoId);
	}

	public Emprestimo getEmprestimo(int empid) {
		return EmprestimoDao.getEmprestimo(empid);
	}

	public Emprestimo updateEmprestimo(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		return EmprestimoDao.updateEmprestimo(emprestimo);
	}

	public void setEmprestimoDao(EmprestimoDao emprestimoDao) {
		this.EmprestimoDao = emprestimoDao;
	}

}
