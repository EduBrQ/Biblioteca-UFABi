package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.AnaisDeCongresso;

public interface IAnaisDeCongressoService {

	List<AnaisDeCongresso> findAll();
	
	AnaisDeCongresso create(AnaisDeCongresso anaisDeCongresso);
	AnaisDeCongresso update(AnaisDeCongresso anaisDeCongresso, Long Id);
	public void remove(Long id);
    
	Optional<AnaisDeCongresso> findOne(Long id);

}
