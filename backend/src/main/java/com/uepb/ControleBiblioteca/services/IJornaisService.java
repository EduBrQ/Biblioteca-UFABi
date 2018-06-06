package com.uepb.ControleBiblioteca.services;

import java.util.List;

import com.uepb.ControleBiblioteca.entities.Jornais;
import com.uepb.ControleBiblioteca.exception.JornaisException;

public interface IJornaisService {
	
	List<Jornais> findAll();
	Jornais findOne(Integer id);
	Jornais create(Jornais jornais);
	Jornais update(Jornais jornais, Integer Id);
	public void remove(Integer id);
    public Jornais findById(Integer id) throws JornaisException;

}
