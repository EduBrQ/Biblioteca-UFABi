package com.jackrutorial.service;

import java.util.List;

import com.jackrutorial.model.Livro;

public interface LivroService {

 public List listAllLivros();
 
 public void addLivro(Livro user);
 
 public void updateLivro(Livro user);
 
 public void deleteLivro(int id);
 
 public Livro findLivroById(int id);
}