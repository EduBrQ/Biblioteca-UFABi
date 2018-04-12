package com.jackrutorial.dao;

import java.util.List;

import com.jackrutorial.model.Livro;

public interface LivroDao{
 
 public List listAllLivros();
 
 public void addLivro(Livro livro);
 
 public void updateLivro(Livro livro);
 
 public void deleteLivro(int id);
 
 public Livro findLivroById(int id);
}
