package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.AnaisDeCongresso;

@Repository
public interface AnaisDeCongressoRepository extends JpaRepository<AnaisDeCongresso, Long> {

	
	
}
