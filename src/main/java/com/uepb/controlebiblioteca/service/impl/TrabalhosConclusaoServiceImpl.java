package com.uepb.controlebiblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.controlebiblioteca.dao.TrabalhosConclusaoDao;
import com.uepb.controlebiblioteca.model.TrabalhosConclusao;
import com.uepb.controlebiblioteca.service.TrabalhosConclusaoService;

@Service
@Transactional
public class TrabalhosConclusaoServiceImpl implements TrabalhosConclusaoService {

	@Autowired
	private TrabalhosConclusaoDao TrabalhosConclusaoDao;

	@Override
	@Transactional
	public void addTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao) {
		TrabalhosConclusaoDao.addTrabalhosConclusao(trabalhosConclusao);
	}

	@Override
	@Transactional
	public List<TrabalhosConclusao> getAllTrabalhosConclusaos() {
		return TrabalhosConclusaoDao.getAllTrabalhosConclusaos();
	}

	@Override
	@Transactional
	public void deleteTrabalhosConclusao(Integer trabalhosConclusaoId) {
		TrabalhosConclusaoDao.deleteTrabalhosConclusao(trabalhosConclusaoId);
	}

	public TrabalhosConclusao getTrabalhosConclusao(int empid) {
		return TrabalhosConclusaoDao.getTrabalhosConclusao(empid);
	}

	public TrabalhosConclusao updateTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao) {
		// TODO Auto-generated method stub
		return TrabalhosConclusaoDao.updateTrabalhosConclusao(trabalhosConclusao);
	}

	public void setTrabalhosConclusaoDao(TrabalhosConclusaoDao trabalhosConclusaoDao) {
		this.TrabalhosConclusaoDao = trabalhosConclusaoDao;
	}

}
