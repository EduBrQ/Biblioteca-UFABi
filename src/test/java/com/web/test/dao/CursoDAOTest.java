package com.web.test.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.web.dao.CursoDAO;
import com.web.model.Curso;

public class CursoDAOTest {

<<<<<<< HEAD
	CursoDAO dao = new CursoDAO();
=======
	CursoDAO uDAO = new CursoDAO();
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	Curso curso;

	@Before
	public void setUp() throws Exception {

		curso = new Curso();

<<<<<<< HEAD
		curso.setNome		("Matematica");
		curso.setArea		("Exatas");
		curso.setNivel		("Graduação");
		curso.setSigla		("MA");
		
=======
		curso.setNome("Nome");
		curso.setArea("Area");
		curso.setNivel("Nivel");

>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	}

	@Test
	public void testCursoDAO() {
		Curso cursoTest = new Curso();

		// Testando o addCurso
<<<<<<< HEAD
		dao.addCurso(this.curso);

		// Testando o getCurso
		cursoTest = dao.getCursoById(1);
		assertEquals(1							, cursoTest.getId(), 0);
		assertEquals("Matematica"				, cursoTest.getNome());
		assertEquals("Exatas"					, cursoTest.getArea());
		assertEquals("Graduação"				, cursoTest.getNivel());
		assertEquals("MA"						, cursoTest.getSigla());

		// Testando o update
		Curso newCurso = new Curso();
		newCurso.setNome		("Historia");
		newCurso.setArea		("Humanas");
		newCurso.setNivel		(3);
		newCurso.setSigla		("HI");
		
		dao.updateCurso(newCurso, curso);
		cursoTest = dao.getCursoById(1);
		assertEquals(1							, cursoTest.getId(), 0);
		assertEquals("Historia"					, cursoTest.getNome());
		assertEquals("Humanas"					, cursoTest.getArea());
		assertEquals("Doutorado"				, cursoTest.getNivel());
		assertEquals("HI"						, cursoTest.getSigla());

		// Testando o delete e verificando se ainda existe
		dao.deleteCurso(cursoTest, 1);
		cursoTest = dao.getCursoById(1);

		assertEquals(null						, cursoTest.getNome());
=======
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
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
	}

}
