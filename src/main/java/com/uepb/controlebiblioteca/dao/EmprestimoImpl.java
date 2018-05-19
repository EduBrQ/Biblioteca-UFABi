package com.uepb.controlebiblioteca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uepb.controlebiblioteca.model.Emprestimo;

/**
 * EmprestimoImpl implementa EmprestimoDao e define as funcionalidades de cada método.
 * @author Eduardo Borba
 *
 */
@Repository
public class EmprestimoImpl implements EmprestimoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmprestimo(Emprestimo emprestimo) {
		sessionFactory.getCurrentSession().saveOrUpdate(emprestimo);

	}

	@SuppressWarnings("unchecked")
	public List<Emprestimo> getAllEmprestimos() {

		return sessionFactory.getCurrentSession().createQuery("from Emprestimo")
				.list();
	}

	@Override
	public void deleteEmprestimo(Integer emprestimoId) {
		Emprestimo emprestimo = (Emprestimo) sessionFactory.getCurrentSession().load(
				Emprestimo.class, emprestimoId);
		if (null != emprestimo) {
			this.sessionFactory.getCurrentSession().delete(emprestimo);
		}

	}

	public Emprestimo getEmprestimo(int empid) {
		return (Emprestimo) sessionFactory.getCurrentSession().get(
				Emprestimo.class, empid);
	}

	@Override
	public Emprestimo updateEmprestimo(Emprestimo emprestimo) {
		sessionFactory.getCurrentSession().update(emprestimo);
		return emprestimo;
	}

}