package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.LivroDAO;
import com.web.model.Livro;

public class LivroDAOTest {
	
	 	LivroDAO uDAO = new LivroDAO();
	 	Livro livro;
	 	
	 	@Before
	 	public void setUp() throws Exception {
	 		
	 		livro = new Livro();

	 		livro.setIsbn("Isbn");
	 		livro.setEditora("Editora");
	 		livro.setTitulo("Titulo");
	 		livro.setAutores("Autores"); // mudar pra array
	 		livro.setEdicao(51);
	 		livro.setAnoPublicacao(anoPublicacao);
	 		livro.setNumPaginas(10);
	 		livro.setAreaConhecimento("AreaConhecimento");
	 		livro.setTema("Tema");
	 		
	 	}
	 	
	 	@Test
	 	public void testLivroDAO() {
	 		Livro livroTest = new Livro();
	 		
	 		//Testando o addLivro
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
	 		
	 		assertEquals(null, 	livroTest.getTitulo());
	 	}


	 }}