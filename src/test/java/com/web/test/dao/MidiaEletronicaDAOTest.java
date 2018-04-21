package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.MidiaEletronicaDAO;
<<<<<<< HEAD
import com.web.model.MidiasEletronicas;
=======
import com.web.model.MidiaEletronica;
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3


public class MidiaEletronicaDAOTest {
	
<<<<<<< HEAD
	MidiaEletronicaDAO dao = new MidiaEletronicaDAO();
	MidiasEletronicas midia;
=======
	MidiaEletronicaDAO uDAO = new MidiaEletronicaDAO();
	MidiaEletronica midiaEletronica;
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	
	@Before
	public void setUp() throws Exception {
			
<<<<<<< HEAD
		midia = new MidiasEletronicas();
		
		midia.setDataGravacao		("19-02-1999");
		midia.setTipo				("cd");
		midia.setTitulo				("Rock Show");
=======
		midiaEletronica = new MidiaEletronica();
		
		midiaEletronica.setTipo("Tipo");
		midiaEletronica.setTitulo("Titulo");
		midiaEletronica.setDataGravacao(dataGravacao);
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
		
	}
	
	@Test
	public void testMidiaEletronicaDAO() {
<<<<<<< HEAD
		MidiasEletronicas midiaTest = new MidiasEletronicas();
		
		//Testando o addMidiaEletronica
		dao.addMidiaEletronica(this.midia);
		
		//Testando o getMidiaEletronica
		midiaTest = dao.getMidiaEletronicaById(1);
		assertEquals(1				, midiaTest.getId(), 0);
		assertEquals("19-02-1999"	, midiaTest.getDataGravacao());
		assertEquals("cd"			, midiaTest.getTipo());
		assertEquals("Rock Show"	, midiaTest.getTitulo());
		
		//Testando o update
		MidiasEletronicas newMidia = new MidiasEletronicas();
		newMidia.setDataGravacao		("22-04-2003");
		newMidia.setTipo				("dvd");
		newMidia.setTitulo				("Band Rock");
		
		dao.updateMidiaEletronica(newMidia, midiaTest);
		midiaTest =  dao.getMidiaEletronicaById(1);
		assertEquals(1				, midiaTest.getId(), 0);
		assertEquals("22-04-2003"	, midiaTest.getDataGravacao());
		assertEquals("dvd"			, midiaTest.getTipo());
		assertEquals("Band Rock"	, midiaTest.getTitulo());
		
		// Testando o delete e verificando se ainda existe
		dao.deleteMidiaEletronica(midiaTest);
		midiaTest = dao.getMidiaEletronicaById(1);
		
		assertEquals(null, 	midiaTest.getTitulo());
=======
		MidiaEletronica midiaEletronicaTest = new MidiaEletronica();
		
		//Testando o addMidiaEletronica
		uDAO.addMidiaEletronica(this.midiaEletronica);
		
		//Testando o getMidiaEletronica
		midiaEletronicaTest = uDAO.getMidiaEletronicaById(1);
		assertEquals("Tipo", 								midiaEletronicaTest.getTipo());
		assertEquals("Titulo", 								midiaEletronicaTest.getTitulo());
		assertEquals(dataGravacao,					 		midiaEletronicaTest.getDataGravacao());
		
		//Testando o update
		MidiaEletronica newMidiaEletronica = new MidiaEletronica();
		newMidiaEletronica.setTitulo("Tipo");
		newMidiaEletronica.setTitulo("Titulo");
		newMidiaEletronica.setDataGravacao(dataGravacao);
		
		uDAO.updateMidiaEletronica(newMidiaEletronica, midiaEletronica);
		midiaEletronicaTest =  uDAO.getMidiaEletronicaById(1);
		
		assertEquals("Tipo", 								midiaEletronicaTest.getTipo());
		assertEquals("Titulo", 								midiaEletronicaTest.getTitulo());
		assertEquals(dataGravacao,					 		midiaEletronicaTest.getDataGravacao());
		
		// Testando o delete e verificando se ainda existe
		uDAO.deleteMidiaEletronica("Titulo");
		midiaEletronicaTest = uDAO.getMidiaEletronicaById(1);
		
		assertEquals(null, 	midiaEletronicaTest.getTitulo());
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	}


}
