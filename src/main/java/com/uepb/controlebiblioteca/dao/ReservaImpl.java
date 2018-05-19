package com.uepb.controlebiblioteca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uepb.controlebiblioteca.model.Reserva;

/**
 * ReservaImpl implementa ReservaDao e define as funcionalidades de cada método.
 * @author Eduardo Borba
 *
 */
@Repository
public class ReservaImpl implements ReservaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addReserva(Reserva reserva) {
		sessionFactory.getCurrentSession().saveOrUpdate(reserva);

	}

	@SuppressWarnings("unchecked")
	public List<Reserva> getAllReservas() {

		return sessionFactory.getCurrentSession().createQuery("from Reserva")
				.list();
	}

	@Override
	public void deleteReserva(Integer reservaId) {
		Reserva reserva = (Reserva) sessionFactory.getCurrentSession().load(
				Reserva.class, reservaId);
		if (null != reserva) {
			this.sessionFactory.getCurrentSession().delete(reserva);
		}

	}

	public Reserva getReserva(int empid) {
		return (Reserva) sessionFactory.getCurrentSession().get(
				Reserva.class, empid);
	}

	@Override
	public Reserva updateReserva(Reserva reserva) {
		sessionFactory.getCurrentSession().update(reserva);
		return reserva;
	}

}