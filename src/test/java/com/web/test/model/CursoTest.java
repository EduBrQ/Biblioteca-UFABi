package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Curso;

public class CursoTest {

	Curso curso;
	
	@Before
	public void setUp() throws Exception {
		curso = new Curso();
		curso.setArea		("Exatas");
		curso.setNivel		("Gradua��o");
		curso.setNome		("Matematica");
		curso.setSigla		("MA");
		curso.setId			(1);
	}

	@Test
	public void test() {
		assertEquals(1				, curso.getId(), 1);
		assertEquals("Exatas"		, curso.getArea());
		assertEquals("Matematica"	, curso.getNome());
		assertEquals("MA"			, curso.getSigla());
		
		assertEquals("Gradua��o"	, curso.getNivel());
		
		curso.setNivel("G");
		assertEquals("Gradua��o"	, curso.getNivel());
		
		curso.setNivel(0);
		assertEquals("Gradua��o"	, curso.getNivel());
		
		
	}

}
