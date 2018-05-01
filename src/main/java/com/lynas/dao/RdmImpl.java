package com.lynas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lynas.model.Rdm;

@Repository
public class RdmImpl implements RdmDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addRdm(Rdm rdm) {
		sessionFactory.getCurrentSession().saveOrUpdate(rdm);

	}

	@SuppressWarnings("unchecked")
	public List<Rdm> getAllRdms() {

		return sessionFactory.getCurrentSession().createQuery("from Rdm")
				.list();
	}

	@Override
	public void deleteRdm(Integer rdmId) {
		Rdm rdm = (Rdm) sessionFactory.getCurrentSession().load(
				Rdm.class, rdmId);
		if (null != rdm) {
			this.sessionFactory.getCurrentSession().delete(rdm);
		}

	}

	public Rdm getRdm(int empid) {
		return (Rdm) sessionFactory.getCurrentSession().get(
				Rdm.class, empid);
	}

	@Override
	public Rdm updateRdm(Rdm rdm) {
		sessionFactory.getCurrentSession().update(rdm);
		return rdm;
	}

}