package com.lynas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lynas.model.Rdm;
import com.lynas.service.RdmService;
import com.lynas.dao.RdmDao;

@Service
@Transactional
public class RdmServiceImpl implements RdmService {

	@Autowired
	private RdmDao RdmDao;

	@Override
	@Transactional
	public void addRdm(Rdm rdm) {
		RdmDao.addRdm(rdm);
	}

	@Override
	@Transactional
	public List<Rdm> getAllRdms() {
		return RdmDao.getAllRdms();
	}

	@Override
	@Transactional
	public void deleteRdm(Integer rdmId) {
		RdmDao.deleteRdm(rdmId);
	}

	public Rdm getRdm(int empid) {
		return RdmDao.getRdm(empid);
	}

	public Rdm updateRdm(Rdm rdm) {
		// TODO Auto-generated method stub
		return RdmDao.updateRdm(rdm);
	}

	public void setRdmDao(RdmDao rdmDao) {
		this.RdmDao = rdmDao;
	}

}
