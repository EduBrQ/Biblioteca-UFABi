package com.lynas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lynas.model.Revista;
import com.lynas.service.RevistaService;
import com.lynas.dao.RevistaDao;

@Service
@Transactional
public class RevistaServiceImpl implements RevistaService {

	@Autowired
	private RevistaDao RevistaDao;

	@Override
	@Transactional
	public void addRevista(Revista revista) {
		RevistaDao.addRevista(revista);
	}

	@Override
	@Transactional
	public List<Revista> getAllRevistas() {
		return RevistaDao.getAllRevistas();
	}

	@Override
	@Transactional
	public void deleteRevista(Integer revistaId) {
		RevistaDao.deleteRevista(revistaId);
	}

	public Revista getRevista(int empid) {
		return RevistaDao.getRevista(empid);
	}

	public Revista updateRevista(Revista revista) {
		// TODO Auto-generated method stub
		return RevistaDao.updateRevista(revista);
	}

	public void setRevistaDao(RevistaDao revistaDao) {
		this.RevistaDao = revistaDao;
	}

}
