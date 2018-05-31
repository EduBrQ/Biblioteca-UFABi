package com.uepb.ControleBiblioteca.services;

import java.util.List;

import com.uepb.ControleBiblioteca.entities.AnaisDeCongresso;
import com.uepb.ControleBiblioteca.exception.AnaisDeCongressoException;

public interface IAnaisDeCongressoService {

	List<AnaisDeCongresso> findAll();
	AnaisDeCongresso findOne(Integer id);
	AnaisDeCongresso create(AnaisDeCongresso aluno);
	AnaisDeCongresso update(AnaisDeCongresso aluno, Integer Id);
	public void remove(Integer id);
    public AnaisDeCongresso findById(Integer id) throws AnaisDeCongressoException;

}
