package com.web.test.model;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.web.model.Livro;

public class LivroTest {

	Livro livro;
	@Before
	public void setUp() throws Exception {
		livro = new Livro();
		
		livro.setId					(2);
		livro.setAnoPublicacao		(1999);
		livro.setAreaConhecimento	("Astronomia");
		livro.setEdicao				(1);
		livro.setEditora			("Grilo Editora");
		livro.setIsbn				("Nao sei o que e isso");
		livro.setNumPaginas			(300);
		livro.setTema				("Explodindo estrelas");
		livro.setTitulo				("Hoje é ontem");
		livro.addAutor				("Joao");
		livro.addAutor				("Pedro");
		livro.addAutor				("Maria");
		
	}

	@Test
	public void testGetters() {
		assertEquals(2							, livro.getId(), 0);
		assertEquals(1999						, livro.getAnoPublicacao(), 0);
		assertEquals("Astronomia"				, livro.getAreaConhecimento());
		assertEquals(1							, livro.getEdicao(), 0);
		assertEquals("Grilo Editora"			, livro.getEditora());
		assertEquals("Nao sei o que e isso"		, livro.getIsbn());
		assertEquals(300						, livro.getNumPaginas(), 0);
		assertEquals("Explodindo estrelas"		, livro.getTema());
		assertEquals("Hoje é ontem"				, livro.getTitulo());
		
		assertEquals("Joao, Pedro, Maria"		, livro.getAutores());
		
		livro.addAutores(new String[]{"Ze", "Jumbo", "Cabe"});
		assertEquals("Joao, Pedro, Maria, Ze, Jumbo, Cabe", livro.getAutores());
	}

}
