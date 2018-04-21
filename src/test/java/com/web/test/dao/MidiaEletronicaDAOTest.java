package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.MidiaEletronicaDAO;
import com.web.model.MidiasEletronicas;


public class MidiaEletronicaDAOTest {
	
	MidiaEletronicaDAO dao = new MidiaEletronicaDAO();
	MidiasEletronicas midia;
	
	@Before
	public void setUp() throws Exception {
			
		midia = new MidiasEletronicas();
		
		midia.setDataGravacao		("19-02-1999");
		midia.setTipo				("cd");
		midia.setTitulo				("Rock Show");
		
	}
	
	@Test
	public void testMidiaEletronicaDAO() {
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
	}


}
