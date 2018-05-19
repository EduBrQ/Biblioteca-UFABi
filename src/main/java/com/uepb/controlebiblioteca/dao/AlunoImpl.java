package com.uepb.controlebiblioteca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uepb.controlebiblioteca.model.Aluno;

/**
 * AlunoImpl implementa AlunoDao e define as funcionalidades de cada método.
 * @author Eduardo Borba
 *
 */
@Repository
public class AlunoImpl implements AlunoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addAluno(Aluno aluno) {
		sessionFactory.getCurrentSession().saveOrUpdate(aluno);

	}

	@SuppressWarnings("unchecked")
	public List<Aluno> getAllAlunos() {

		return sessionFactory.getCurrentSession().createQuery("from Aluno")
				.list();
	}

	@Override
	public void deleteAluno(Integer alunoId) {
		Aluno aluno = (Aluno) sessionFactory.getCurrentSession().load(
				Aluno.class, alunoId);
		if (null != aluno) {
			this.sessionFactory.getCurrentSession().delete(aluno);
		}

	}

	public Aluno getAluno(int empid) {
		return (Aluno) sessionFactory.getCurrentSession().get(
				Aluno.class, empid);
	}

	@Override
	public Aluno updateAluno(Aluno aluno) {
		sessionFactory.getCurrentSession().update(aluno);
		return aluno;
	}

}