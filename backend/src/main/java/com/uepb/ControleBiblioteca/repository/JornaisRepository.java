package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.Jornais;

@Repository
public interface JornaisRepository extends JpaRepository<Jornais, Integer> {

	Jornais findOne(int id);
	Jornais update(Jornais jornais, Long id);
	
}
