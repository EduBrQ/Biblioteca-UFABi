package com.web.test.dao;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.web.dao.AnaisCongressoDAO;
import com.web.model.AnaisCongresso;

public class AnaisCongressoDAOTest {


<<<<<<< HEAD
		AnaisCongressoDAO dao = new AnaisCongressoDAO();
		AnaisCongresso anaisCongresso;

	
=======
		AnaisCongressoDAO uDAO = new AnaisCongressoDAO();
		AnaisCongresso anaisCongresso;

>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
		@Before
		public void setUp() throws Exception {

			anaisCongresso = new AnaisCongresso();

<<<<<<< HEAD
			anaisCongresso.setTipo					("artigo");
			anaisCongresso.setNomeCongresso			("NomeCongresso");
			anaisCongresso.setLocal					("Local");
=======
			anaisCongresso.setTipo("Tipo");
			anaisCongresso.setNomeCongresso("NomeCongresso");
			anaisCongresso.setLocal("Local");
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3

		}

		@Test
		public void testAnaisCongressoDAO() {
			AnaisCongresso anaisCongressoTest = new AnaisCongresso();

			// Testando o addAnaisCongresso
<<<<<<< HEAD
			dao.addAnaisCongresso(this.anaisCongresso);

			
			// Testando o getAnaisCongresso
			anaisCongressoTest = dao.getAnaisCongressoById(1);
			assertEquals(1						, anaisCongressoTest.getId(), 0);
			assertEquals("artigo"				, anaisCongressoTest.getTipo());
			assertEquals("NomeCongresso"		, anaisCongressoTest.getNomeCongresso());
			assertEquals("Local"				, anaisCongressoTest.getLocal());

			// Testando o update
			AnaisCongresso newAnaisCongresso = new AnaisCongresso();
			newAnaisCongresso.setTipo("pôster");
			newAnaisCongresso.setNomeCongresso("NomeCongresso");
			newAnaisCongresso.setLocal("Local");

			dao.updateAnaisCongresso(newAnaisCongresso, anaisCongresso);
			anaisCongressoTest = dao.getAnaisCongressoById(1);
			assertEquals(1						, anaisCongressoTest.getId(), 0);
			assertEquals("pôster"				, anaisCongressoTest.getTipo());
			assertNotEquals("artigo"			, anaisCongressoTest.getTipo());
			assertEquals("NomeCongresso"		, anaisCongressoTest.getNomeCongresso());
			assertEquals("Local"				, anaisCongressoTest.getLocal());

			// Testando o delete e verificando se ainda existe
			dao.deleteAnaisCongresso(1);
			anaisCongressoTest = dao.getAnaisCongressoById(1);

			assertEquals(null					, anaisCongressoTest.getLocal());
			
=======
			uDAO.addAnaisCongresso(this.anaisCongresso);

			// Testando o getAnaisCongresso
			anaisCongressoTest = uDAO.getAnaisCongressoById(1);
			assertEquals("Tipo", anaisCongressoTest.getTipo());
			assertEquals("NomeCongresso", anaisCongressoTest.getNomeCongresso());
			assertEquals("Local", anaisCongressoTest.getLocal());

			// Testando o update
			AnaisCongresso newAnaisCongresso = new AnaisCongresso();
			newAnaisCongresso.setTipo("Tipo");
			newAnaisCongresso.setNomeCongresso("NomeCongresso");
			newAnaisCongresso.setLocal("Local");

			uDAO.updateAnaisCongresso(newAnaisCongresso, anaisCongresso);
			anaisCongressoTest = uDAO.getAnaisCongressoById(1);

			assertEquals("Tipo", anaisCongressoTest.getTipo());
			assertEquals("NomeCongresso", anaisCongressoTest.getNomeCongresso());
			assertEquals("Local", anaisCongressoTest.getLocal());

			// Testando o delete e verificando se ainda existe
			uDAO.deleteAnaisCongresso(1);
			anaisCongressoTest = uDAO.getAnaisCongressoById(1);

			assertEquals(null, anaisCongressoTest.getId());
>>>>>>> ca010b164675a97ea148118b95fded66341d51e3
		}

	}
