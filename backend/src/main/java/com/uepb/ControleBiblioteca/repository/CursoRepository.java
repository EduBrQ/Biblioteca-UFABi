package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	Curso findOne(int id);
	Curso update(Curso curso, int id);
	
}
