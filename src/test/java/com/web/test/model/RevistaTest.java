package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Revista;

public class RevistaTest {

	Revista revista;
	
	@Before
	public void setUp() throws Exception {
		revista = new Revista();
		
		revista.setId				(1);
		revista.setDataPublicacao	("12-02-1999");
		revista.setEdicao			(3);
		revista.setEditora			("Editora do mal");
		revista.setNumPaginas		(450);
		revista.setTitulo			("Epoca");
	}

	@Test
	public void test() {
		assertEquals(1					, revista.getId(), 0);
		assertEquals("12-02-1999"		, revista.getDataPublicacao());
		assertEquals(3					, revista.getEdicao(), 0);
		assertEquals("Editora do mal"	, revista.getEditora());
		assertEquals(450				, revista.getNumPaginas(), 0);
		assertEquals("Epoca"			, revista.getTitulo());
	}

}
