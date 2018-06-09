package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.Curso;
import com.uepb.ControleBiblioteca.entities.Jornais;
import com.uepb.ControleBiblioteca.entities.Jornais;
import com.uepb.ControleBiblioteca.exception.JornaisException;

public interface IJornaisService {
	
	List<Jornais> findAll();
	Optional<Jornais> findOne(Long id);
	Jornais create(Jornais jornal);
	Jornais update(Jornais jornal, Long Id);
	public void remove(Long id);
//    public Jornais findById(Long id) throws JornaisException;

}
