package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.TrabalhoConclusaoDAO;
import com.web.model.TrabalhoConclusao;


public class TrabalhoConclusaoDAOTest {
	
	
	TrabalhoConclusaoDAO uDAO = new TrabalhoConclusaoDAO();
	TrabalhoConclusao trabalhoConclusao;
	
	@Before
	public void setUp() throws Exception {
		
		trabalhoConclusao = new TrabalhoConclusao();
		
		trabalhoConclusao.setTitulo("Titulo");
		trabalhoConclusao.setAutor("Autor");
		trabalhoConclusao.setOrientador("Orientador");
		trabalhoConclusao.setTipo("Tipo");
		trabalhoConclusao.setAnoDefesa(anoDefesa);
		trabalhoConclusao.setLocal("Local");
		
	}
	
	@Test
	public void testTrabalhoConclusaoDAO() {
		TrabalhoConclusao trabalhoConclusaoTest = new TrabalhoConclusao();
		
		//Testando o addTrabalhoConclusao
		uDAO.addTrabalhoConclusao(this.trabalhoConclusao);
		
		//Testando o getTrabalhoConclusao
		trabalhoConclusaoTest = uDAO.getTrabalhoConclusaoById(1);
		assertEquals("Titulo", 							trabalhoConclusaoTest.getTitulo());
		assertEquals("Autor", 							trabalhoConclusaoTest.getAutor());
		assertEquals("Orientador",				 		trabalhoConclusaoTest.getOrientador());
		assertEquals("Tipo",  			 				trabalhoConclusaoTest.getTipo());
		assertEquals(anoDefesa, 						trabalhoConclusaoTest.getAnoDefesa());
		
		//Testando o update
		TrabalhoConclusao newTrabalhoConclusao = new TrabalhoConclusao();
		newTrabalhoConclusao.setTitulo("Titulo");
		newTrabalhoConclusao.setAutor("Autor");
		newTrabalhoConclusao.setOrientador("Orientador");
		newTrabalhoConclusao.setTipo("Tipo");
		newTrabalhoConclusao.setAnoDefesa(anoDefesa);
		
		uDAO.updateTrabalhoConclusao(newTrabalhoConclusao, trabalhoConclusao);
		trabalhoConclusaoTest =  uDAO.getTrabalhoConclusaoById(1);
		
		assertEquals("Titulo", 							trabalhoConclusaoTest.getTitulo());
		assertEquals("Autor",				 			trabalhoConclusaoTest.getAutor());
		assertEquals("Orientador",				 		trabalhoConclusaoTest.getOrientador());
		assertEquals("Tipo",					 		trabalhoConclusaoTest.getTipo());
		assertNotEquals(anoDefesa,		 				trabalhoConclusaoTest.getAnoDefesa());
		
		// Testando o delete e verificando se ainda existe
		uDAO.deleteTrabalhoConclusao("Titulo");
		trabalhoConclusaoTest = uDAO.getTrabalhoConclusaoById(1);
		
		assertEquals(null, 	trabalhoConclusaoTest.getTitulo());
	}


}
