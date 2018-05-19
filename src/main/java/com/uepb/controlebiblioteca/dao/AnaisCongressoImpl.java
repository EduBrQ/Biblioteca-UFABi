package com.uepb.controlebiblioteca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uepb.controlebiblioteca.model.AnaisCongresso;

/**
 * AnaisCongressoImpl implementa AnaisCongressoDao e define as funcionalidades de cada método.
 * @author Eduardo Borba
 *
 */
@Repository
public class AnaisCongressoImpl implements AnaisCongressoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addAnaisCongresso(AnaisCongresso anaisCongresso) {
		sessionFactory.getCurrentSession().saveOrUpdate(anaisCongresso);

	}

	@SuppressWarnings("unchecked")
	public List<AnaisCongresso> getAllAnaisCongressos() {

		return sessionFactory.getCurrentSession().createQuery("from AnaisCongresso")
				.list();
	}

	@Override
	public void deleteAnaisCongresso(Integer anaisCongressoId) {
		AnaisCongresso anaisCongresso = (AnaisCongresso) sessionFactory.getCurrentSession().load(
				AnaisCongresso.class, anaisCongressoId);
		if (null != anaisCongresso) {
			this.sessionFactory.getCurrentSession().delete(anaisCongresso);
		}

	}

	public AnaisCongresso getAnaisCongresso(int empid) {
		return (AnaisCongresso) sessionFactory.getCurrentSession().get(
				AnaisCongresso.class, empid);
	}

	@Override
	public AnaisCongresso updateAnaisCongresso(AnaisCongresso anaisCongresso) {
		sessionFactory.getCurrentSession().update(anaisCongresso);
		return anaisCongresso;
	}

}