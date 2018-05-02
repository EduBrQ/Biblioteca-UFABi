package com.uepb.controlebiblioteca.service;

import java.util.List;

import com.uepb.controlebiblioteca.model.Revista;

public interface RevistaService {
	
	public void addRevista(Revista revista);

	public List<Revista> getAllRevistas();

	public void deleteRevista(Integer revistaId);

	public Revista getRevista(int revistaid);

	public Revista updateRevista(Revista revista);
}
