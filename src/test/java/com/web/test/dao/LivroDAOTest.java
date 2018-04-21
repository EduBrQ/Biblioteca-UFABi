package com.web.test.dao;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.LivroDAO;
import com.web.model.Livro;

public class LivroDAOTest {
	
	 	LivroDAO dao = new LivroDAO();
	 	Livro livro;
	 	
	 	@Before
	 	public void setUp() throws Exception {
	 		
	 		livro = new Livro();

			livro.setTitulo				("Hoje � ontem");
			livro.setEditora			("Grilo Editora");
			livro.setEdicao				(1);
			livro.addAutor				("Joao");
			livro.addAutor				("Pedro");
			livro.addAutor				("Maria");
			livro.setAnoPublicacao		(1999);
			livro.setNumPaginas			(300);
			livro.setAreaConhecimento	("Astronomia");
			livro.setTema				("Explodindo estrelas");
			livro.setIsbn				("Nao sei o que e isso");
	 		
	 	}
	 	
	 	@Test
	 	public void testLivroDAO() {
	 		Livro livroTest = new Livro();
	 		
	 		//Testando o addLivro
	 		dao.addLivro(this.livro);
	 		
	 		//Testando o getLivro
	 		livroTest = dao.getLivroById(1);
	 		assertEquals(1									, livroTest.getId());
	 		assertEquals("Hoje � ontem"						, livroTest.getTitulo());
	 		assertEquals("Grilo Editora"					, livroTest.getEditora());
	 		assertEquals(1									, livroTest.getEdicao());
	 		assertEquals("Joao, Pedro, Maria"				, livroTest.getAutores());
	 		assertEquals(1999								, livroTest.getAnoPublicacao(), 0);
	 		assertEquals(300								, livroTest.getNumPaginas());
	 		assertEquals("Astronomia"						, livroTest.getAreaConhecimento());
	 		assertEquals("Explodindo estrelas"				, livroTest.getTema());
	 		assertEquals("Nao sei o que e isso"				, livroTest.getIsbn());
	 		
	 		//Testando o update
	 		Livro newLivro = new Livro();
	 		newLivro.setTitulo				("Hoje � ontem");
	 		newLivro.setEditora				("Grilo Editora");
	 		newLivro.setEdicao				(2);
	 		newLivro.addAutores				(new String[] {"Barbosa", "Ti�o", "Barulho"});
	 		newLivro.setAnoPublicacao		(2005);
	 		newLivro.setNumPaginas			(450);
	 		newLivro.setAreaConhecimento	("Astronomia");
	 		newLivro.setTema				("Explodindo estrelas");
	 		newLivro.setIsbn				("Nao sei o que e isso");
	 		
	 		
	 		dao.updateLivro(newLivro, livro);
	 		livroTest =  dao.getLivroById(1);
	 		assertEquals(1									, livroTest.getId());
	 		assertEquals("Hoje � ontem"						, livroTest.getTitulo());
	 		assertEquals("Grilo Editora"					, livroTest.getEditora());
	 		assertEquals(2									, livroTest.getEdicao());
	 		assertEquals("Barbosa, Ti�o, Barulho"			, livroTest.getAutores());
	 		assertEquals(2005								, livroTest.getAnoPublicacao(), 0);
	 		assertEquals(450								, livroTest.getNumPaginas());
	 		assertEquals("Astronomia"						, livroTest.getAreaConhecimento());
	 		assertEquals("Explodindo estrelas"				, livroTest.getTema());
	 		assertEquals("Nao sei o que e isso"				, livroTest.getIsbn());
	 		
	 		// Testando o delete e verificando se ainda existe
	 		dao.deleteLivro(livroTest);
	 		livroTest = dao.getLivroById(1);
	 		
	 		assertEquals(null, 	livroTest.getTitulo());
	 		
	 		
	 		// Testando pegando todos os Livros
	 		
	 		List<Livro> list = new ArrayList<Livro>();
	 		
	 		for(int i=0; i<5; i++) {
	 			list.add(this.livro);
	 			dao.addLivro(this.livro);
	 		}
	 		
	 		List<Livro> list2 = dao.getAllLivros();
	 		
	 		for(int i=0; i<list.size(); i++) {
	 			assertEquals(list.get(i).getAnoPublicacao()			, list2.get(i).getAnoPublicacao());
	 			assertEquals(list.get(i).getAreaConhecimento()		, list2.get(i).getAreaConhecimento());
	 			assertEquals(list.get(i).getAutores()				, list2.get(i).getAutores());
	 			assertEquals(list.get(i).getEdicao()				, list2.get(i).getEdicao());
	 			assertEquals(list.get(i).getEditora()				, list2.get(i).getEditora());
	 			assertEquals(list.get(i).getIsbn()					, list2.get(i).getIsbn());
	 			assertEquals(list.get(i).getNumPaginas()			, list2.get(i).getNumPaginas());
	 			assertEquals(list.get(i).getTema()					, list2.get(i).getTema());
	 			assertEquals(list.get(i).getTitulo()				, list2.get(i).getTitulo());
	 		}
	 	}

}