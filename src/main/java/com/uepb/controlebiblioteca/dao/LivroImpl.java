package com.uepb.controlebiblioteca.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uepb.controlebiblioteca.model.Livro;

/**
 * LivroImpl implementa LivroDao e define as funcionalidades de cada método.
 * @author Eduardo Borba
 *
 */
@Repository
public class LivroImpl implements LivroDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addLivro(Livro livro) {
		sessionFactory.getCurrentSession().saveOrUpdate(livro);

	}

	@SuppressWarnings("unchecked")
	public List<Livro> getAllLivros() {

		return sessionFactory.getCurrentSession().createQuery("from Livro")
				.list();
	}

	@Override
	public void deleteLivro(Integer livroId) {
		Livro livro = (Livro) sessionFactory.getCurrentSession().load(
				Livro.class, livroId);
		if (null != livro) {
			this.sessionFactory.getCurrentSession().delete(livro);
		}

	}

	public Livro getLivro(int empid) {
		return (Livro) sessionFactory.getCurrentSession().get(
				Livro.class, empid);
	}

	@Override
	public Livro updateLivro(Livro livro) {
		sessionFactory.getCurrentSession().update(livro);
		return livro;
	}

}