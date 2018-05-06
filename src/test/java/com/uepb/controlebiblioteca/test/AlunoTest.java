package com.uepb.controlebiblioteca.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.uepb.controlebiblioteca.model.Aluno;

public class AlunoTest {

	Aluno aluno;

	@Before
	public void setUp() {
		aluno = new Aluno();
	}

	@Test
	public void testGetPeriodo() {
		aluno.setPeriodo("4");

		assertNotNull(aluno);

		assertEquals("4", aluno.getPeriodo());

		assertNotEquals("5", aluno.getPeriodo());
	}

	@Test
	public void testGetSenha() {
		aluno.setSenha("123");

		assertNotNull(aluno);

		assertEquals("123", aluno.getSenha());

		assertNotEquals("345", aluno.getSenha());
	}

	@Test
	public void testGetMatricula() {
		aluno.setMatricula("gpc9085");

		assertNotNull(aluno);

		assertEquals("gpc9085", aluno.getMatricula());

		assertNotEquals("345988", aluno.getMatricula());
	}

	@Test
	public void testGetNomeCompleto() {
		aluno.setNomeCompleto("Thiago Pablício");

		assertNotNull(aluno);

		assertEquals("Thiago Pablício", aluno.getNomeCompleto());

		assertNotEquals("Aleksandro Fabrício", aluno.getNomeCompleto());
	}

	@Test
	public void testGetTelefone() {
		aluno.setTelefone("8399098988");

		assertNotNull(aluno);

		assertEquals("8399098988", aluno.getTelefone());

		assertNotEquals("7666548754", aluno.getTelefone());
	}

	@Test
	public void testGetEndereco() {
		aluno.setEndereco("Rua Abba");

		assertNotNull(aluno);

		assertEquals("Rua Abba", aluno.getEndereco());

		assertNotEquals("Rua Pintombas", aluno.getEndereco());
	}

	@Test
	public void testGetCpf() {
		aluno.setCpf("09898899876");

		assertNotNull(aluno);

		assertEquals("09898899876", aluno.getCpf());

		assertNotEquals("09898899875", aluno.getCpf());
	}

	@Test
	public void testGetRg() {
		aluno.setRg("8987765");

		assertNotNull(aluno);

		assertEquals("8987765", aluno.getRg());

		assertNotEquals("76865698", aluno.getRg());
	}

	@Test
	public void testGetNomeMae() {
		aluno.setNomeMae("Elidia Cabral");

		assertNotNull(aluno);

		assertEquals("Elidia Cabral", aluno.getNomeMae());

		assertNotEquals("Maria da Silva", aluno.getNomeMae());
	}

	@Test
	public void testGetNomePai() {
		aluno.setNomePai("Antônio Nunes");

		assertNotNull(aluno);

		assertEquals("Antônio Nunes", aluno.getNomePai());

		assertNotEquals("Marcelo Carvalho", aluno.getNomePai());
	}

	@Test
	public void testGetNaturalidade() {
		aluno.setNaturalidade("Argentino");

		assertNotNull(aluno);

		assertEquals("Argentino", aluno.getNaturalidade());

		assertNotEquals("Brasileiro", aluno.getNaturalidade());
	}

}
