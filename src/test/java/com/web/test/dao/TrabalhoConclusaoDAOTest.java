package com.web.test.dao;
import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.TrabalhoConclusaoDAO;
<<<<<<< HEAD
import com.web.model.TrabalhosConclusao;
=======
import com.web.model.TrabalhoConclusao;
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3


public class TrabalhoConclusaoDAOTest {
	
	
<<<<<<< HEAD
	TrabalhoConclusaoDAO dao = new TrabalhoConclusaoDAO();
	TrabalhosConclusao trabalhoConclusao;
=======
	TrabalhoConclusaoDAO uDAO = new TrabalhoConclusaoDAO();
	TrabalhoConclusao trabalhoConclusao;
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	
	@Before
	public void setUp() throws Exception {
		
<<<<<<< HEAD
		trabalhoConclusao = new TrabalhosConclusao();
		
		trabalhoConclusao.setAnoDefesa		(1999);
		trabalhoConclusao.setAutor			("Tio Darth");
		trabalhoConclusao.setLocal			("Fundo do po�o");
		trabalhoConclusao.setTipo			("monografia");
		trabalhoConclusao.setTitulo			("O dia em que consegui dormir");
		trabalhoConclusao.setOrientador		("Skymarchante");
=======
		trabalhoConclusao = new TrabalhoConclusao();
		
		trabalhoConclusao.setTitulo("Titulo");
		trabalhoConclusao.setAutor("Autor");
		trabalhoConclusao.setOrientador("Orientador");
		trabalhoConclusao.setTipo("Tipo");
		trabalhoConclusao.setAnoDefesa(anoDefesa);
		trabalhoConclusao.setLocal("Local");
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
		
	}
	
	@Test
	public void testTrabalhoConclusaoDAO() {
<<<<<<< HEAD
		TrabalhosConclusao trabalhoConclusaoTest = new TrabalhosConclusao();
		
		//Testando o addTrabalhoConclusao
		dao.addTrabalhoConclusao(this.trabalhoConclusao);
		
		//Testando o getTrabalhoConclusao
		trabalhoConclusaoTest = dao.getTrabalhoConclusaoById(1);
		assertEquals(1									, trabalhoConclusaoTest.getId(), 0);
		assertEquals(1999								, trabalhoConclusaoTest.getAnoDefesa(), 0);
		assertEquals("Tio Darth"						, trabalhoConclusaoTest.getAutor());
		assertEquals("Fundo do po�o"					, trabalhoConclusaoTest.getLocal());
		assertEquals("monografia"						, trabalhoConclusaoTest.getTipo());
		assertEquals("O dia em que consegui dormir"		, trabalhoConclusaoTest.getTitulo());
		assertEquals("Skymarchante"						, trabalhoConclusaoTest.getOrientador());
		
		//Testando o update
		TrabalhosConclusao newTrabalhoConclusao = new TrabalhosConclusao();
		newTrabalhoConclusao.setAnoDefesa		(2079);
		newTrabalhoConclusao.setAutor			("Tio Darth Filho");
		newTrabalhoConclusao.setLocal			("Beira do abismo");
		newTrabalhoConclusao.setTipo			("disserta��o");
		newTrabalhoConclusao.setTitulo			("O dia em que atrasei o trabalho");
		newTrabalhoConclusao.setOrientador		("Chor�o");
		
		dao.updateTrabalhoConclusao(newTrabalhoConclusao, trabalhoConclusao);
		trabalhoConclusaoTest =  dao.getTrabalhoConclusaoById(1);
		assertEquals(1										, trabalhoConclusaoTest.getId(), 0);
		assertEquals(2079									, trabalhoConclusaoTest.getAnoDefesa(), 0);
		assertEquals("Tio Darth Filho"						, trabalhoConclusaoTest.getAutor());
		assertEquals("Beira do abismo"						, trabalhoConclusaoTest.getLocal());
		assertEquals("disserta��o"							, trabalhoConclusaoTest.getTipo());
		assertEquals("O dia em que atrasei o trabalho"		, trabalhoConclusaoTest.getTitulo());
		assertEquals("Chor�o"								, trabalhoConclusaoTest.getOrientador());
		
		// Testando o delete e verificando se ainda existe
		dao.deleteTrabalhoConclusao(trabalhoConclusaoTest);
		trabalhoConclusaoTest = dao.getTrabalhoConclusaoById(1);
=======
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
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
		
		assertEquals(null, 	trabalhoConclusaoTest.getTitulo());
	}


}
