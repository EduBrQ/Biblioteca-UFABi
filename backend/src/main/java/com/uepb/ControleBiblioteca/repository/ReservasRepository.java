package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

	Reservas findOne(int id);
	Reservas update(Reservas reservas, int id);
	
}
