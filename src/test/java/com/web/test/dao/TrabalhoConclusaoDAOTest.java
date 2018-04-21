package com.web.test.dao;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.TrabalhoConclusaoDAO;
import com.web.model.TrabalhosConclusao;


public class TrabalhoConclusaoDAOTest {
	
	
	TrabalhoConclusaoDAO dao = new TrabalhoConclusaoDAO();
	TrabalhosConclusao trabalhoConclusao;
	
	@Before
	public void setUp() throws Exception {
		
		trabalhoConclusao = new TrabalhosConclusao();
		
		trabalhoConclusao.setAnoDefesa		(1999);
		trabalhoConclusao.setAutor			("Tio Darth");
		trabalhoConclusao.setLocal			("Fundo do poço");
		trabalhoConclusao.setTipo			("monografia");
		trabalhoConclusao.setTitulo			("O dia em que consegui dormir");
		trabalhoConclusao.setOrientador		("Skymarchante");
		
	}
	
	@Test
	public void testTrabalhoConclusaoDAO() {
		TrabalhosConclusao trabalhoConclusaoTest = new TrabalhosConclusao();
		
		//Testando o addTrabalhoConclusao
		dao.addTrabalhoConclusao(this.trabalhoConclusao);
		
		//Testando o getTrabalhoConclusao
		trabalhoConclusaoTest = dao.getTrabalhoConclusaoById(1);
		assertEquals(1									, trabalhoConclusaoTest.getId(), 0);
		assertEquals(1999								, trabalhoConclusaoTest.getAnoDefesa(), 0);
		assertEquals("Tio Darth"						, trabalhoConclusaoTest.getAutor());
		assertEquals("Fundo do poço"					, trabalhoConclusaoTest.getLocal());
		assertEquals("monografia"						, trabalhoConclusaoTest.getTipo());
		assertEquals("O dia em que consegui dormir"		, trabalhoConclusaoTest.getTitulo());
		assertEquals("Skymarchante"						, trabalhoConclusaoTest.getOrientador());
		
		//Testando o update
		TrabalhosConclusao newTrabalhoConclusao = new TrabalhosConclusao();
		newTrabalhoConclusao.setAnoDefesa		(2079);
		newTrabalhoConclusao.setAutor			("Tio Darth Filho");
		newTrabalhoConclusao.setLocal			("Beira do abismo");
		newTrabalhoConclusao.setTipo			("dissertação");
		newTrabalhoConclusao.setTitulo			("O dia em que atrasei o trabalho");
		newTrabalhoConclusao.setOrientador		("Chorão");
		
		dao.updateTrabalhoConclusao(newTrabalhoConclusao, trabalhoConclusao);
		trabalhoConclusaoTest =  dao.getTrabalhoConclusaoById(1);
		assertEquals(1										, trabalhoConclusaoTest.getId(), 0);
		assertEquals(2079									, trabalhoConclusaoTest.getAnoDefesa(), 0);
		assertEquals("Tio Darth Filho"						, trabalhoConclusaoTest.getAutor());
		assertEquals("Beira do abismo"						, trabalhoConclusaoTest.getLocal());
		assertEquals("dissertação"							, trabalhoConclusaoTest.getTipo());
		assertEquals("O dia em que atrasei o trabalho"		, trabalhoConclusaoTest.getTitulo());
		assertEquals("Chorão"								, trabalhoConclusaoTest.getOrientador());
		
		// Testando o delete e verificando se ainda existe
		dao.deleteTrabalhoConclusao(trabalhoConclusaoTest);
		trabalhoConclusaoTest = dao.getTrabalhoConclusaoById(1);
		
		assertEquals(null, 	trabalhoConclusaoTest.getTitulo());
		
		// Testando pegando todos os trabalhos
		
		List<TrabalhosConclusao> list = new ArrayList<TrabalhosConclusao>();
		
		for(int i=0; i<5; i++) {
			list.add(this.trabalhoConclusao);
			dao.addTrabalhoConclusao(this.trabalhoConclusao);
		}
		
		List<TrabalhosConclusao> list2 = dao.getAllTrabalhoConclusaos();
		
		for(int i=0; i<list.size(); i++) {
			assertEquals(list.get(i).getAnoDefesa()		, list2.get(i).getAnoDefesa());
			assertEquals(list.get(i).getAutor()			, list2.get(i).getAutor());
			assertEquals(list.get(i).getLocal()			, list2.get(i).getLocal());
			assertEquals(list.get(i).getOrientador()	, list2.get(i).getOrientador());
			assertEquals(list.get(i).getTipo()			, list2.get(i).getTipo());
			assertEquals(list.get(i).getTitulo()		, list2.get(i).getTitulo());
		}
	}


}
