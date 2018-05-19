package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.Revista;

/**
 * Interface que define os metodos que podem ser utilizados implementando a mesma.
 * @author Eduardo Borba
 *
 */
public interface RevistaDao {

	public void addRevista(Revista livro);

	public List<Revista> getAllRevistas();

	public void deleteRevista(Integer livroId);

	public Revista updateRevista(Revista livro);

	public Revista getRevista(int livroid);
}
