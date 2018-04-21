package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.MidiasEletronicas;

public class MidiasElet {
	
	MidiasEletronicas midia;

	@Before
	public void setUp() throws Exception {
		midia = new MidiasEletronicas();
		
		midia.setId				(1);
		midia.setDataGravacao	("19-02-1999");
		midia.setTipo			("cd");
		midia.setTitulo			("Rock Show");
	}

	@Test
	public void testGetters() {
		assertEquals(1				, midia.getId(), 0);
		assertEquals("19-02-1999"	, midia.getDataGravacao());
		assertEquals("cd"			, midia.getTipo());
		assertEquals("Rock Show"	, midia.getTitulo());
	}

}
