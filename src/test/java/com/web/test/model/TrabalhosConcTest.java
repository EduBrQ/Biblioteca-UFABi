package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.TrabalhosConclusao;

public class TrabalhosConcTest {

	TrabalhosConclusao trabalhoConclusao;
	
	@Before
	public void setUp() throws Exception {
		trabalhoConclusao = new TrabalhosConclusao();
		
		trabalhoConclusao.setId				(4);
		trabalhoConclusao.setAnoDefesa		(1999);
		trabalhoConclusao.setAutor			("Tio Darth");
		trabalhoConclusao.setLocal			("Fundo do poço");
		trabalhoConclusao.setTipo			("monografia");
		trabalhoConclusao.setTitulo			("O dia em que consegui dormir");
		trabalhoConclusao.setOrientador		("Skymarchante");
	}

	
	@Test
	public void test() {
		assertEquals(4									, trabalhoConclusao.getId(), 0);
		assertEquals(1999								, trabalhoConclusao.getAnoDefesa(), 0);
		assertEquals("Tio Darth"						, trabalhoConclusao.getAutor());
		assertEquals("Fundo do poço"					, trabalhoConclusao.getLocal());
		assertEquals("monografia"						, trabalhoConclusao.getTipo());
		assertEquals("O dia em que consegui dormir"		, trabalhoConclusao.getTitulo());
		assertEquals("Skymarchante"						, trabalhoConclusao.getOrientador());
	}

}
