package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.RevistaDAO;
import com.web.model.Revista;


public class RevistaDAOTest {
	
<<<<<<< HEAD
	RevistaDAO dao = new RevistaDAO();
=======
	RevistaDAO uDAO = new RevistaDAO();
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	Revista revista;
	
	@Before
	public void setUp() throws Exception {
		
		revista = new Revista();
		
<<<<<<< HEAD
		revista.setDataPublicacao	("12-02-1999");
		revista.setEdicao			(3);
		revista.setEditora			("Editora do mal");
		revista.setNumPaginas		(50);
		revista.setTitulo			("Epoca");
=======
		revista.setTitulo("Titulo");
		revista.setEditora("Editora");
		revista.setDataPublicacao(dataPublicacao);
		revista.setEdicao(51);
		revista.setNumPaginas(10);
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
		
	}
	
	@Test
	public void testRevistaDAO() {
		Revista revistaTest = new Revista();
		
		//Testando o addRevista
<<<<<<< HEAD
		dao.addRevista(this.revista);
		
		//Testando o getRevista
		revistaTest = dao.getRevistaById(1);
		assertEquals(1					, revistaTest.getId(), 0);
		assertEquals("12-02-1999"		, revistaTest.getDataPublicacao());
		assertEquals(3					, revistaTest.getEdicao(), 0);
		assertEquals("Editora do mal"	, revistaTest.getEditora());
		assertEquals(50					, revistaTest.getNumPaginas(), 0);
		assertEquals("Epoca"			, revistaTest.getTitulo());
		
		//Testando o update
		Revista newRevista = new Revista();
		newRevista.setDataPublicacao	("12-03-1999");
		newRevista.setEdicao			(4);
		newRevista.setEditora			("Editora do mal");
		newRevista.setNumPaginas		(66);
		newRevista.setTitulo			("Epoca");
		
		dao.updateRevista(newRevista, revista);
		revistaTest =  dao.getRevistaById(1);
		assertEquals(1					, revistaTest.getId(), 0);
		assertEquals("12-03-1999"		, revistaTest.getDataPublicacao());
		assertEquals(4					, revistaTest.getEdicao(), 0);
		assertEquals("Editora do mal"	, revistaTest.getEditora());
		assertEquals(66					, revistaTest.getNumPaginas(), 0);
		assertEquals("Epoca"			, revistaTest.getTitulo());
		
		// Testando o delete e verificando se ainda existe
		dao.deleteRevista(revistaTest);
		revistaTest = dao.getRevistaById(1);
=======
		uDAO.addRevista(this.revista);
		
		//Testando o getRevista
		revistaTest = uDAO.getRevistaById(1);
		assertEquals("Titulo", 								revistaTest.getTitulo());
		assertEquals("Editora", 							revistaTest.getEditora());
		assertEquals(dataPublicacao,				 		revistaTest.getDataPublicacao());
		assertEquals(51,  					 				revistaTest.getEdicao());
		assertEquals(10,			 						revistaTest.getNumPaginas());
		
		//Testando o update
		Revista newRevista = new Revista();
		newRevista.setTitulo("Titulo");
		newRevista.setEditora("Editora");
		newRevista.setDataPublicacao(dataPublicacao);
		newRevista.setEdicao(51);
		newRevista.setNumPaginas(10);
		
		uDAO.updateRevista(newRevista, revista);
		revistaTest =  uDAO.getRevistaById(1);
		
		assertEquals("Titulo", 							revistaTest.getTitulo());
		assertEquals("Editora",				 			revistaTest.getEditora());
		assertEquals(dataPublicacao,			 		revistaTest.getDataPublicacao());
		assertEquals(51,						 		revistaTest.getEdicao());
		assertNotEquals(10,				 				revistaTest.getNumPaginas());
		
		// Testando o delete e verificando se ainda existe
		uDAO.deleteRevista("Titulo");
		revistaTest = uDAO.getRevistaById(1);
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
		
		assertEquals(null, 	revistaTest.getTitulo());
	}


}
