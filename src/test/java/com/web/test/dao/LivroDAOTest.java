package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.LivroDAO;
import com.web.model.Livro;

public class LivroDAOTest {
	
<<<<<<< HEAD
	 	LivroDAO dao = new LivroDAO();
=======
	 	LivroDAO uDAO = new LivroDAO();
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	 	Livro livro;
	 	
	 	@Before
	 	public void setUp() throws Exception {
	 		
	 		livro = new Livro();

<<<<<<< HEAD
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
=======
	 		livro.setIsbn("Isbn");
	 		livro.setEditora("Editora");
	 		livro.setTitulo("Titulo");
	 		livro.setAutores("Autores"); // mudar pra array
	 		livro.setEdicao(51);
	 		livro.setAnoPublicacao(anoPublicacao);
	 		livro.setNumPaginas(10);
	 		livro.setAreaConhecimento("AreaConhecimento");
	 		livro.setTema("Tema");
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	 		
	 	}
	 	
	 	@Test
	 	public void testLivroDAO() {
	 		Livro livroTest = new Livro();
	 		
	 		//Testando o addLivro
<<<<<<< HEAD
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
=======
	 		uDAO.addLivro(this.livro);
	 		
	 		//Testando o getLivro
	 		livroTest = uDAO.getLivroById(1);
	 		assertEquals("Titulo", 								livroTest.getTitulo());
	 		assertEquals("Editora", 							livroTest.getEditora());
	 		assertEquals("Titulo", 								livroTest.getTitulo());
	 		assertEquals("Autores", 							livroTest.getAutores());
	 		assertEquals(51,							 		livroTest.getEdicao());
	 		assertEquals(anoPublicacao,				 			livroTest.getAnoPublicacao());
	 		assertEquals(10,				 					livroTest.getNumPaginas());
	 		assertEquals("AreaConhecimento",  					livroTest.getAreaConhecimento());
	 		assertEquals("Tema",			 					livroTest.getTema());
	 		
	 		//Testando o update
	 		Livro newLivro = new Livro();
	 		newLivro.setIsbn("Isbn");
	 		newLivro.setEditora("Editora");
	 		newLivro.setTitulo("Titulo");
	 		newLivro.setAutores("Autores"); // mudar pra array
	 		newLivro.setEdicao(51);
	 		newLivro.setAnoPublicacao(anoPublicacao);
	 		newLivro.setNumPaginas(10);
	 		newLivro.setAreaConhecimento("AreaConhecimento");
	 		newLivro.setTema("Tema");
	 		
	 		uDAO.updateLivro(newLivro, livro);
	 		livroTest =  uDAO.getLivroById(1);
	 		
	 		assertEquals("Titulo", 								livroTest.getTitulo());
	 		assertEquals("Editora", 							livroTest.getEditora());
	 		assertEquals("Titulo", 								livroTest.getTitulo());
	 		assertEquals("Autores", 							livroTest.getAutores());
	 		assertEquals(51,							 		livroTest.getEdicao());
	 		assertEquals(anoPublicacao,				 			livroTest.getAnoPublicacao());
	 		assertEquals(10,				 					livroTest.getNumPaginas());
	 		assertEquals("AreaConhecimento",  					livroTest.getAreaConhecimento());
	 		assertEquals("Tema",			 					livroTest.getTema());
	 		
	 		// Testando o delete e verificando se ainda existe
	 		uDAO.deleteLivro("Titulo");
	 		livroTest = uDAO.getLivroById(1);
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	 		
	 		assertEquals(null, 	livroTest.getTitulo());
	 	}

<<<<<<< HEAD
}
=======

	 }}
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
