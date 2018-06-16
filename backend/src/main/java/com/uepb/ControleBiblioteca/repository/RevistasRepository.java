package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.Revistas;

@Repository
public interface RevistasRepository extends JpaRepository<Revistas, Long> {

	
}
