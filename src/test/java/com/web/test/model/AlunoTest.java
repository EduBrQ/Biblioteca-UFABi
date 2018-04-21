package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Aluno;

public class AlunoTest {

	Aluno aluno;
	
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno();
		
		aluno.setId				(3);
		aluno.setNomeCompleto	("Nome completo do cidadao");
		aluno.setEndereco		("Rua do aluno");
		aluno.setTelefone		("(83)9.8888-8888");
		
		aluno.setNaturalidade	("Marte");
		aluno.setNomeMae		("Nome da mae completo");
		aluno.setNomePai		("Nome do pai completo");
		
		aluno.setCpf			("175.777.950-70"); // Precisa ser um cpf valido
		aluno.setRg				("12312322");

	}
	
	@Test
	public void testGetters() {
		
		assertEquals(3								, aluno.getId(), 0);
		assertEquals("Nome completo do cidadao"		, aluno.getNomeCompleto());
		assertEquals("Rua do aluno"					, aluno.getEndereco());
		assertEquals("(83)9.8888-8888"				, aluno.getTelefone());
		assertEquals("Marte"						, aluno.getNaturalidade());
		assertEquals("Nome da mae completo"			, aluno.getNomeMae());
		assertEquals("Nome do pai completo"			, aluno.getNomePai());
		assertEquals("175.777.950-70"				, aluno.getCpf());		
		assertEquals("12312322"						, aluno.getRg());
		
	}

	

}
