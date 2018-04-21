package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.RevistaDAO;
import com.web.model.Revista;


public class RevistaDAOTest {
	
	RevistaDAO uDAO = new RevistaDAO();
	Revista revista;
	
	@Before
	public void setUp() throws Exception {
		
		revista = new Revista();
		
		revista.setTitulo("Titulo");
		revista.setEditora("Editora");
		revista.setDataPublicacao(dataPublicacao);
		revista.setEdicao(51);
		revista.setNumPaginas(10);
		
	}
	
	@Test
	public void testRevistaDAO() {
		Revista revistaTest = new Revista();
		
		//Testando o addRevista
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
		
		assertEquals(null, 	revistaTest.getTitulo());
	}


}
