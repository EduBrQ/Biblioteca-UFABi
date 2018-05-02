package com.uepb.controlebiblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.controlebiblioteca.dao.CursoDao;
import com.uepb.controlebiblioteca.model.Curso;
import com.uepb.controlebiblioteca.service.CursoService;

@Service
@Transactional
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoDao CursoDao;

	@Override
	@Transactional
	public void addCurso(Curso curso) {
		CursoDao.addCurso(curso);
	}

	@Override
	@Transactional
	public List<Curso> getAllCursos() {
		return CursoDao.getAllCursos();
	}

	@Override
	@Transactional
	public void deleteCurso(Integer cursoId) {
		CursoDao.deleteCurso(cursoId);
	}

	public Curso getCurso(int empid) {
		return CursoDao.getCurso(empid);
	}

	public Curso updateCurso(Curso curso) {
		// TODO Auto-generated method stub
		return CursoDao.updateCurso(curso);
	}

	public void setCursoDao(CursoDao cursoDao) {
		this.CursoDao = cursoDao;
	}

}
