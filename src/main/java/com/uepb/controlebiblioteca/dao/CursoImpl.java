package com.uepb.controlebiblioteca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uepb.controlebiblioteca.model.Curso;

/**
 * CursoImpl implementa CursoDao e define as funcionalidades de cada método.
 * @author Eduardo Borba
 *
 */
@Repository
public class CursoImpl implements CursoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCurso(Curso curso) {
		sessionFactory.getCurrentSession().saveOrUpdate(curso);

	}

	@SuppressWarnings("unchecked")
	public List<Curso> getAllCursos() {

		return sessionFactory.getCurrentSession().createQuery("from Curso")
				.list();
	}

	@Override
	public void deleteCurso(Integer cursoId) {
		Curso curso = (Curso) sessionFactory.getCurrentSession().load(
				Curso.class, cursoId);
		if (null != curso) {
			this.sessionFactory.getCurrentSession().delete(curso);
		}

	}

	public Curso getCurso(int empid) {
		return (Curso) sessionFactory.getCurrentSession().get(
				Curso.class, empid);
	}

	@Override
	public Curso updateCurso(Curso curso) {
		sessionFactory.getCurrentSession().update(curso);
		return curso;
	}

}