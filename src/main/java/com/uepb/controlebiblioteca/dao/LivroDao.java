package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.Livro;

/**
 * Interface que define os metodos que podem ser utilizados implementando a mesma.
 * @author Eduardo Borba
 *
 */
public interface LivroDao {

	public void addLivro(Livro livro);

	public List<Livro> getAllLivros();

	public void deleteLivro(Integer livroId);

	public Livro updateLivro(Livro livro);

	public Livro getLivro(int livroid);
}
