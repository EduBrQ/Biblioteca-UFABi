package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.RevistaDAO;
import com.web.model.Revista;


public class RevistaDAOTest {
	
	RevistaDAO dao = new RevistaDAO();
	Revista revista;
	
	@Before
	public void setUp() throws Exception {
		
		revista = new Revista();
		
		revista.setDataPublicacao	("12-02-1999");
		revista.setEdicao			(3);
		revista.setEditora			("Editora do mal");
		revista.setNumPaginas		(50);
		revista.setTitulo			("Epoca");
		
	}
	
	@Test
	public void testRevistaDAO() {
		Revista revistaTest = new Revista();
		
		//Testando o addRevista
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
		
		assertEquals(null, 	revistaTest.getTitulo());
	}


}