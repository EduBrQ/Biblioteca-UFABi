package com.lynas.dao;

import java.util.List;
import com.lynas.model.Livro;

public interface LivroDao {

	public void addLivro(Livro livro);

	public List<Livro> getAllLivros();

	public void deleteLivro(Integer livroId);

	public Livro updateLivro(Livro livro);

	public Livro getLivro(int livroid);
}
