package com.web.test.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.web.dao.CursoDAO;
import com.web.model.Curso;

public class CursoDAOTest {

	CursoDAO uDAO = new CursoDAO();
	Curso curso;

	@Before
	public void setUp() throws Exception {

		curso = new Curso();

		curso.setNome("Nome");
		curso.setArea("Area");
		curso.setNivel("Nivel");

	}

	@Test
	public void testCursoDAO() {
		Curso cursoTest = new Curso();

		// Testando o addCurso
		uDAO.addCurso(this.curso);

		// Testando o getCurso
		cursoTest = uDAO.getCursoById(1);
		assertEquals("Nome", cursoTest.getNome());
		assertEquals("Area", cursoTest.getArea());
		assertEquals("Nivel", cursoTest.getNivel());

		// Testando o update
		Curso newCurso = new Curso();
		newCurso.setArea("Nome");
		newCurso.setArea("Area");
		newCurso.setNivel("Nivel");

		uDAO.updateCurso(newCurso, curso);
		cursoTest = uDAO.getCursoById(1);

		assertEquals("Nome", cursoTest.getNome());
		assertEquals("Area", cursoTest.getArea());
		assertEquals("Nivel", cursoTest.getNivel());

		// Testando o delete e verificando se ainda existe
		uDAO.deleteCurso("Nome");
		cursoTest = uDAO.getCursoById(1);

		assertEquals(null, cursoTest.getNome());
	}

}
