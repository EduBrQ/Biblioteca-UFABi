package com.uepb.ControleBiblioteca.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	


}
