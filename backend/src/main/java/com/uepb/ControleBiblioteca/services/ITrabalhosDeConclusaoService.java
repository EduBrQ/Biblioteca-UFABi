package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.TrabalhosDeConclusao;

public interface ITrabalhosDeConclusaoService {

	List<TrabalhosDeConclusao> findAll();
	Optional<TrabalhosDeConclusao> findOne(Long id);
	TrabalhosDeConclusao create(TrabalhosDeConclusao trabalhosDeConclusao);
	TrabalhosDeConclusao update(TrabalhosDeConclusao trabalhosDeConclusao, Long Id);
	public void remove(Long id);

}
