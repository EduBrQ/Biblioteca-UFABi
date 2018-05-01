package com.lynas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lynas.model.Revista;

@Repository
public class RevistaImpl implements RevistaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addRevista(Revista revista) {
		sessionFactory.getCurrentSession().saveOrUpdate(revista);

	}

	@SuppressWarnings("unchecked")
	public List<Revista> getAllRevistas() {

		return sessionFactory.getCurrentSession().createQuery("from Revista")
				.list();
	}

	@Override
	public void deleteRevista(Integer revistaId) {
		Revista revista = (Revista) sessionFactory.getCurrentSession().load(
				Revista.class, revistaId);
		if (null != revista) {
			this.sessionFactory.getCurrentSession().delete(revista);
		}

	}

	public Revista getRevista(int empid) {
		return (Revista) sessionFactory.getCurrentSession().get(
				Revista.class, empid);
	}

	@Override
	public Revista updateRevista(Revista revista) {
		sessionFactory.getCurrentSession().update(revista);
		return revista;
	}

}