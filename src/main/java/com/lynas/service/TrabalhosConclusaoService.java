package com.lynas.service;

import java.util.List;

import com.lynas.model.TrabalhosConclusao;

public interface TrabalhosConclusaoService {
	
	public void addTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao);

	public List<TrabalhosConclusao> getAllTrabalhosConclusaos();

	public void deleteTrabalhosConclusao(Integer trabalhosConclusaoId);

	public TrabalhosConclusao getTrabalhosConclusao(int trabalhosConclusaoid);

	public TrabalhosConclusao updateTrabalhosConclusao(TrabalhosConclusao trabalhosConclusao);
}
