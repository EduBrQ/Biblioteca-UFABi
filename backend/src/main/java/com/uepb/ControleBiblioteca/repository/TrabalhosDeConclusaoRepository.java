package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.TrabalhosDeConclusao;

@Repository
public interface TrabalhosDeConclusaoRepository extends JpaRepository<TrabalhosDeConclusao, Integer> {

	TrabalhosDeConclusao findOne(int id);
	TrabalhosDeConclusao update(TrabalhosDeConclusao trabalhosDeConclusao, int id);
	
}
