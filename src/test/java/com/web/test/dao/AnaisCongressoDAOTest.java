package com.web.test.dao;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.web.dao.AnaisCongressoDAO;
import com.web.model.AnaisCongresso;

public class AnaisCongressoDAOTest {


		AnaisCongressoDAO uDAO = new AnaisCongressoDAO();
		AnaisCongresso anaisCongresso;

		@Before
		public void setUp() throws Exception {

			anaisCongresso = new AnaisCongresso();

			anaisCongresso.setTipo("Tipo");
			anaisCongresso.setNomeCongresso("NomeCongresso");
			anaisCongresso.setLocal("Local");

		}

		@Test
		public void testAnaisCongressoDAO() {
			AnaisCongresso anaisCongressoTest = new AnaisCongresso();

			// Testando o addAnaisCongresso
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
		}

	}
