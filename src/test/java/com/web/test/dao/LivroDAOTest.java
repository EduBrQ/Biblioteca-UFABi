package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.LivroDAO;
import com.web.model.Livro;

public class LivroDAOTest {
	
	 	LivroDAO dao = new LivroDAO();
	 	Livro livro;
	 	
	 	@Before
	 	public void setUp() throws Exception {
	 		
	 		livro = new Livro();

			livro.setTitulo				("Hoje é ontem");
			livro.setEditora			("Grilo Editora");
			livro.setEdicao				(1);
			livro.addAutor				("Joao");
			livro.addAutor				("Pedro");
			livro.addAutor				("Maria");
			livro.setAnoPublicacao		(1999);
			livro.setNumPaginas			(300);
			livro.setAreaConhecimento	("Astronomia");
			livro.setTema				("Explodindo estrelas");
			livro.setIsbn				("Nao sei o que e isso");
	 		
	 	}
	 	
	 	@Test
	 	public void testLivroDAO() {
	 		Livro livroTest = new Livro();
	 		
	 		//Testando o addLivro
	 		dao.addLivro(this.livro);
	 		
	 		//Testando o getLivro
	 		livroTest = dao.getLivroById(1);
	 		assertEquals(1									, livroTest.getId());
	 		assertEquals("Hoje é ontem"						, livroTest.getTitulo());
	 		assertEquals("Grilo Editora"					, livroTest.getEditora());
	 		assertEquals(1									, livroTest.getEdicao());
	 		assertEquals("Joao, Pedro, Maria"				, livroTest.getAutores());
	 		assertEquals(1999								, livroTest.getAnoPublicacao(), 0);
	 		assertEquals(300								, livroTest.getNumPaginas());
	 		assertEquals("Astronomia"						, livroTest.getAreaConhecimento());
	 		assertEquals("Explodindo estrelas"				, livroTest.getTema());
	 		assertEquals("Nao sei o que e isso"				, livroTest.getIsbn());
	 		
	 		//Testando o update
	 		Livro newLivro = new Livro();
	 		newLivro.setTitulo				("Hoje é ontem");
	 		newLivro.setEditora				("Grilo Editora");
	 		newLivro.setEdicao				(2);
	 		newLivro.addAutores				(new String[] {"Barbosa", "Tião", "Barulho"});
	 		newLivro.setAnoPublicacao		(2005);
	 		newLivro.setNumPaginas			(450);
	 		newLivro.setAreaConhecimento	("Astronomia");
	 		newLivro.setTema				("Explodindo estrelas");
	 		newLivro.setIsbn				("Nao sei o que e isso");
	 		
	 		
	 		dao.updateLivro(newLivro, livro);
	 		livroTest =  dao.getLivroById(1);
	 		assertEquals(1									, livroTest.getId());
	 		assertEquals("Hoje é ontem"						, livroTest.getTitulo());
	 		assertEquals("Grilo Editora"					, livroTest.getEditora());
	 		assertEquals(2									, livroTest.getEdicao());
	 		assertEquals("Barbosa, Tião, Barulho"			, livroTest.getAutores());
	 		assertEquals(2005								, livroTest.getAnoPublicacao(), 0);
	 		assertEquals(450								, livroTest.getNumPaginas());
	 		assertEquals("Astronomia"						, livroTest.getAreaConhecimento());
	 		assertEquals("Explodindo estrelas"				, livroTest.getTema());
	 		assertEquals("Nao sei o que e isso"				, livroTest.getIsbn());
	 		
	 		// Testando o delete e verificando se ainda existe
	 		dao.deleteLivro(livroTest);
	 		livroTest = dao.getLivroById(1);
	 		
	 		assertEquals(null, 	livroTest.getTitulo());
	 	}

}