package com.uepb.controlebiblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.controlebiblioteca.dao.AnaisCongressoDao;
import com.uepb.controlebiblioteca.model.AnaisCongresso;
import com.uepb.controlebiblioteca.service.AnaisCongressoService;

@Service
@Transactional
public class AnaisCongressoServiceImpl implements AnaisCongressoService {

	@Autowired
	private AnaisCongressoDao AnaisCongressoDao;

	@Override
	@Transactional
	public void addAnaisCongresso(AnaisCongresso anaisCongresso) {
		AnaisCongressoDao.addAnaisCongresso(anaisCongresso);
	}

	@Override
	@Transactional
	public List<AnaisCongresso> getAllAnaisCongressos() {
		return AnaisCongressoDao.getAllAnaisCongressos();
	}

	@Override
	@Transactional
	public void deleteAnaisCongresso(Integer anaisCongressoId) {
		AnaisCongressoDao.deleteAnaisCongresso(anaisCongressoId);
	}

	public AnaisCongresso getAnaisCongresso(int empid) {
		return AnaisCongressoDao.getAnaisCongresso(empid);
	}

	public AnaisCongresso updateAnaisCongresso(AnaisCongresso anaisCongresso) {
		// TODO Auto-generated method stub
		return AnaisCongressoDao.updateAnaisCongresso(anaisCongresso);
	}

	public void setAnaisCongressoDao(AnaisCongressoDao anaisCongressoDao) {
		this.AnaisCongressoDao = anaisCongressoDao;
	}

}
