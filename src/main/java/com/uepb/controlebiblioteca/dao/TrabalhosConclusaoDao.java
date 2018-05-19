package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.TrabalhosConclusao;

/**
 * Interface que define os metodos que podem ser utilizados implementando a mesma.
 * @author Eduardo Borba
 *
 */
public interface TrabalhosConclusaoDao {

	public void addTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao);

	public List<TrabalhosConclusao> getAllTrabalhosConclusaos();

	public void deleteTrabalhosConclusao(Integer trabalhosConclusaoId);

	public TrabalhosConclusao updateTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao);

	public TrabalhosConclusao getTrabalhosConclusao(int trabalhosConclusaoid);
}
