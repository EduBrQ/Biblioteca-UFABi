package com.web.test.resources;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.web.resources.Ferramentas;

public class FerramentasTest {
	
	@Test
	public void testListToStringInline() {
		ArrayList<String> lista = new ArrayList<String>();
		
		lista.add("Teste1");
		lista.add("Teste2");
		lista.add("Teste3");
		
		assertEquals("Teste1, Teste2, Teste3", Ferramentas.listToStringInline(lista));
		
	}
	
	@Test
	public void testVerificaCPF() {
		String[] cpfs_validos = {"175.777.950-70", "767.298.550-70"};
		String[] cpfs_invalidos = {"172.777.950-70", "711.298.520-70"};
		
		assertEquals(true, Ferramentas.verificaCPF(cpfs_validos[0]));
		assertEquals(false, Ferramentas.verificaCPF(cpfs_invalidos[0]));
		
		assertNotEquals(false, Ferramentas.verificaCPF(cpfs_validos[1]));
		assertNotEquals(true, Ferramentas.verificaCPF(cpfs_invalidos[1]));
	}

}
