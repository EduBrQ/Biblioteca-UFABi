package com.uepb.controlebiblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.controlebiblioteca.dao.ReservaDao;
import com.uepb.controlebiblioteca.model.Reserva;
import com.uepb.controlebiblioteca.service.ReservaService;

@Service
@Transactional
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaDao ReservaDao;

	@Override
	@Transactional
	public void addReserva(Reserva reserva) {
		ReservaDao.addReserva(reserva);
	}

	@Override
	@Transactional
	public List<Reserva> getAllReservas() {
		return ReservaDao.getAllReservas();
	}

	@Override
	@Transactional
	public void deleteReserva(Integer reservaId) {
		ReservaDao.deleteReserva(reservaId);
	}

	public Reserva getReserva(int empid) {
		return ReservaDao.getReserva(empid);
	}

	public Reserva updateReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return ReservaDao.updateReserva(reserva);
	}

	public void setReservaDao(ReservaDao reservaDao) {
		this.ReservaDao = reservaDao;
	}

}
