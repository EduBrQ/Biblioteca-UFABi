package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.TrabalhosConclusao;

public interface TrabalhosConclusaoDao {

	public void addTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao);

	public List<TrabalhosConclusao> getAllTrabalhosConclusaos();

	public void deleteTrabalhosConclusao(Integer trabalhosConclusaoId);

	public TrabalhosConclusao updateTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao);

	public TrabalhosConclusao getTrabalhosConclusao(int trabalhosConclusaoid);
}
