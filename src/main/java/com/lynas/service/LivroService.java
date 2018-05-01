package com.lynas.service;

import java.util.List;

import com.lynas.model.Livro;

public interface LivroService {
	
	public void addLivro(Livro livro);

	public List<Livro> getAllLivros();

	public void deleteLivro(Integer livroId);

	public Livro getLivro(int livroid);

	public Livro updateLivro(Livro livro);
}
