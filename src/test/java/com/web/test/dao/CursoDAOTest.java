package com.web.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.CursoDAO;
import com.web.model.Curso;

public class CursoDAOTest {

	CursoDAO dao = new CursoDAO();
	Curso curso;

	@Before
	public void setUp() throws Exception {

		curso = new Curso();

		curso.setNome		("Matematica");
		curso.setArea		("Exatas");
		curso.setNivel		("Graduação");
		curso.setSigla		("MA");
		
	}

	@Test
	public void testCursoDAO() {
		Curso cursoTest = new Curso();

		// Testando o addCurso
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
		
		List<Curso> list = new ArrayList<Curso>();
		
		for(int i=0; i<5; i++) {
			list.add(this.curso);
			dao.addCurso(this.curso);
		}
		
		List<Curso> lista2 = dao.getAllCursos();
		
		for(int i=0; i<list.size(); i++) {
		
		}
	}

}
