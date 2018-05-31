package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.Emprestimos;

@Repository
public interface EmprestimosRepository extends JpaRepository<Emprestimos, Integer> {

	Emprestimos findOne(int id);
	Emprestimos update(Emprestimos emprestimos, int id);
	
}
