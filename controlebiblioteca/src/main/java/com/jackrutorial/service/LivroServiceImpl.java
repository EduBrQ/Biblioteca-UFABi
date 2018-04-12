package com.jackrutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackrutorial.dao.LivroDao;
import com.jackrutorial.model.Livro;

@Service
public class LivroServiceImpl implements LivroService {
 
 LivroDao livroDao;
 
 @Autowired
 public void setLivroDao(LivroDao livroDao) {
  this.livroDao = livroDao;
 }

 public List listAllLivros() {
  return livroDao.listAllLivros();
 }

 public void addLivro(Livro livro) {
  livroDao.addLivro(livro);
 }

 public void updateLivro(Livro livro) {
  livroDao.updateLivro(livro);
 }

 public void deleteLivro(int id) {
  livroDao.deleteLivro(id);
 }

 public Livro findLivroById(int id) {
  return livroDao.findLivroById(id);
 }

}