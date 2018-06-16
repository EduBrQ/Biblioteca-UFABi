package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.Revistas;

public interface IRevistasService {

	List<Revistas> findAll();
	Optional<Revistas> findOne(Long id);
	Revistas create(Revistas revistas);
	Revistas update(Revistas revistas, Long Id);
	public void remove(Long id);

}
