package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Integer> {

	Livros findOne(int id);
	Livros update(Livros livros, int id);
	
}
