package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.AnaisCongresso;

public class AnaisConTest {

	AnaisCongresso aCon;
	
	@Before
	public void setUp() throws Exception {
		aCon = new AnaisCongresso();
		
		/* Setters **/
		aCon.setTipo("artigo");
		aCon.setLocal("Local");
		aCon.setNomeCongresso("Grande congresso");
	}

	@Test
	public void testGetters() {
		assertEquals("artigo", aCon.getTipo());
		assertEquals("Local", aCon.getLocal());
		assertEquals("Grande congresso", aCon.getNomeCongresso());
	}
	

}
