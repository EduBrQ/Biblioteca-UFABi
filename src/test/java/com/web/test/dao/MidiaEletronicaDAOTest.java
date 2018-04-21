package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.MidiaEletronicaDAO;
import com.web.model.MidiaEletronica;


public class MidiaEletronicaDAOTest {
	
	MidiaEletronicaDAO uDAO = new MidiaEletronicaDAO();
	MidiaEletronica midiaEletronica;
	
	@Before
	public void setUp() throws Exception {
			
		midiaEletronica = new MidiaEletronica();
		
		midiaEletronica.setTipo("Tipo");
		midiaEletronica.setTitulo("Titulo");
		midiaEletronica.setDataGravacao(dataGravacao);
		
	}
	
	@Test
	public void testMidiaEletronicaDAO() {
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
	}


}
