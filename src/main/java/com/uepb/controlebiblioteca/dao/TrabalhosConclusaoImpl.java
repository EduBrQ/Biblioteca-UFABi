package com.uepb.controlebiblioteca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uepb.controlebiblioteca.model.TrabalhosConclusao;

/**
 * TrabalhosConclusaoImpl implementa TrabalhosConclusaoDao e define as funcionalidades de cada método.
 * @author Eduardo Borba
 *
 */
@Repository
public class TrabalhosConclusaoImpl implements TrabalhosConclusaoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao) {
		sessionFactory.getCurrentSession().saveOrUpdate(trabalhosConclusao);

	}

	@SuppressWarnings("unchecked")
	public List<TrabalhosConclusao> getAllTrabalhosConclusaos() {

		return sessionFactory.getCurrentSession().createQuery("from TrabalhosConclusao")
				.list();
	}

	@Override
	public void deleteTrabalhosConclusao(Integer trabalhosConclusaoId) {
		TrabalhosConclusao trabalhosConclusao = (TrabalhosConclusao) sessionFactory.getCurrentSession().load(
				TrabalhosConclusao.class, trabalhosConclusaoId);
		if (null != trabalhosConclusao) {
			this.sessionFactory.getCurrentSession().delete(trabalhosConclusao);
		}

	}

	public TrabalhosConclusao getTrabalhosConclusao(int empid) {
		return (TrabalhosConclusao) sessionFactory.getCurrentSession().get(
				TrabalhosConclusao.class, empid);
	}

	@Override
	public TrabalhosConclusao updateTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao) {
		sessionFactory.getCurrentSession().update(trabalhosConclusao);
		return trabalhosConclusao;
	}

}