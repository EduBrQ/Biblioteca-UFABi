package com.web.test.dao;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;

import com.web.dao.AnaisCongressoDAO;
import com.web.model.AnaisCongresso;

public class AnaisCongressoDAOTest {


		AnaisCongressoDAO dao = new AnaisCongressoDAO();
		AnaisCongresso anaisCongresso;

	
		@Before
		public void setUp() throws Exception {

			anaisCongresso = new AnaisCongresso();
			
			anaisCongresso.setTipo					("artigo");
			anaisCongresso.setNomeCongresso			("NomeCongresso");
			anaisCongresso.setLocal					("Local");

		}

		@Test
		public void testAnaisCongressoDAO() {
			AnaisCongresso anaisCongressoTest = new AnaisCongresso();

			// Testando o addAnaisCongresso
			dao.addAnaisCongresso(this.anaisCongresso);

			
			// Testando o getAnaisCongresso
			anaisCongressoTest = dao.getAnaisCongressoById(1);
			assertEquals(1						, anaisCongressoTest.getId(), 0);
			assertEquals("artigo"				, anaisCongressoTest.getTipo());
			assertEquals("NomeCongresso"		, anaisCongressoTest.getNomeCongresso());
			assertEquals("Local"				, anaisCongressoTest.getLocal());

			// Testando o update
			AnaisCongresso newAnaisCongresso = new AnaisCongresso();
			newAnaisCongresso.setTipo("p�ster");
			newAnaisCongresso.setNomeCongresso("NomeCongresso");
			newAnaisCongresso.setLocal("Local");

			dao.updateAnaisCongresso(newAnaisCongresso, anaisCongresso);
			anaisCongressoTest = dao.getAnaisCongressoById(1);
			assertEquals(1						, anaisCongressoTest.getId(), 0);
			assertEquals("p�ster"				, anaisCongressoTest.getTipo());
			assertNotEquals("artigo"			, anaisCongressoTest.getTipo());
			assertEquals("NomeCongresso"		, anaisCongressoTest.getNomeCongresso());
			assertEquals("Local"				, anaisCongressoTest.getLocal());

			// Testando o delete e verificando se ainda existe
			dao.deleteAnaisCongresso(1);
			anaisCongressoTest = dao.getAnaisCongressoById(1);

			assertEquals(null					, anaisCongressoTest.getLocal());
			
			// Testando o List adicionando v�rios itens
			List<AnaisCongresso> list = new ArrayList<AnaisCongresso>();
			
			for(int i=0; i<5; i++) {
				list.add(this.anaisCongresso);
				dao.addAnaisCongresso(list.get(i));
			}
			
			List<AnaisCongresso> list2 = dao.getAllAnaisCongressos();
			
			for(int i=0; i< list.size(); i++) {
				assertEquals(list.get(i).getLocal()				, list2.get(i).getLocal());
				assertEquals(list.get(i).getNomeCongresso()		, list2.get(i).getNomeCongresso());
				assertEquals(list.get(i).getTipo()				, list2.get(i).getTipo());
			}
		}

	}
