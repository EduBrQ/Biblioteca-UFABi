package com.lynas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lynas.model.Livro;
import com.lynas.service.LivroService;
import com.lynas.dao.LivroDao;

@Service
@Transactional
public class LivroServiceImpl implements LivroService {

	@Autowired
	private LivroDao LivroDao;

	@Override
	@Transactional
	public void addLivro(Livro livro) {
		LivroDao.addLivro(livro);
	}

	@Override
	@Transactional
	public List<Livro> getAllLivros() {
		return LivroDao.getAllLivros();
	}

	@Override
	@Transactional
	public void deleteLivro(Integer livroId) {
		LivroDao.deleteLivro(livroId);
	}

	public Livro getLivro(int empid) {
		return LivroDao.getLivro(empid);
	}

	public Livro updateLivro(Livro livro) {
		// TODO Auto-generated method stub
		return LivroDao.updateLivro(livro);
	}

	public void setLivroDao(LivroDao livroDao) {
		this.LivroDao = livroDao;
	}

}
