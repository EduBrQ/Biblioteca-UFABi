package com.uepb.controlebiblioteca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uepb.controlebiblioteca.model.Funcionario;

/**
 * FuncionarioImpl implementa FuncionarioDao e define as funcionalidades de cada método.
 * @author Eduardo Borba
 *
 */
@Repository
public class FuncionarioImpl implements FuncionarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addFuncionario(Funcionario funcionario) {
		sessionFactory.getCurrentSession().saveOrUpdate(funcionario);

	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllFuncionarios() {

		return sessionFactory.getCurrentSession().createQuery("from Funcionario")
				.list();
	}

	@Override
	public void deleteFuncionario(Integer funcionarioId) {
		Funcionario funcionario = (Funcionario) sessionFactory.getCurrentSession().load(
				Funcionario.class, funcionarioId);
		if (null != funcionario) {
			this.sessionFactory.getCurrentSession().delete(funcionario);
		}

	}

	public Funcionario getFuncionario(int empid) {
		return (Funcionario) sessionFactory.getCurrentSession().get(
				Funcionario.class, empid);
	}

	@Override
	public Funcionario updateFuncionario(Funcionario funcionario) {
		sessionFactory.getCurrentSession().update(funcionario);
		return funcionario;
	}

}