package com.uepb.ControleBiblioteca.services;

import java.util.List;

import com.uepb.ControleBiblioteca.entities.TrabalhosDeConclusao;
import com.uepb.ControleBiblioteca.exception.TrabalhosDeConclusaoException;

public interface ITrabalhosDeConclusaoService {
	
	List<TrabalhosDeConclusao> findAll();
	TrabalhosDeConclusao findOne(Integer id);
	TrabalhosDeConclusao create(TrabalhosDeConclusao trabalhosDeConclusao);
	TrabalhosDeConclusao update(TrabalhosDeConclusao trabalhosDeConclusao, Integer Id);
	public void remove(Integer id);
    public TrabalhosDeConclusao findById(Integer id) throws TrabalhosDeConclusaoException;

}
