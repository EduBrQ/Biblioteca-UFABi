package com.lynas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lynas.model.Aluno;
import com.lynas.service.AlunoService;
import com.lynas.dao.AlunoDao;

@Service
@Transactional
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoDao AlunoDao;

	@Override
	@Transactional
	public void addAluno(Aluno aluno) {
		AlunoDao.addAluno(aluno);
	}

	@Override
	@Transactional
	public List<Aluno> getAllAlunos() {
		return AlunoDao.getAllAlunos();
	}

	@Override
	@Transactional
	public void deleteAluno(Integer alunoId) {
		AlunoDao.deleteAluno(alunoId);
	}

	public Aluno getAluno(int empid) {
		return AlunoDao.getAluno(empid);
	}

	public Aluno updateAluno(Aluno aluno) {
		// TODO Auto-generated method stub
		return AlunoDao.updateAluno(aluno);
	}

	public void setAlunoDao(AlunoDao alunoDao) {
		this.AlunoDao = alunoDao;
	}

}
