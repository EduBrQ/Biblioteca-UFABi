package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Aluno;
import com.web.model.Curso;
import com.web.model.RDM;

public class RDMTest {
	
	RDM rdm;
	Aluno aluno;
	Curso curso;

	@Before
	public void setUp() throws Exception {
		
		aluno = new Aluno();
		
		aluno.setId				(16);
		aluno.setNomeCompleto	("Nome completo do cidadao");
		aluno.setEndereco		("Rua do aluno");
		aluno.setTelefone		("(83)9.8888-8888");
		aluno.setNaturalidade	("Marte");
		aluno.setNomeMae		("Nome da mae completo");
		aluno.setNomePai		("Nome do pai completo");
		aluno.setCpf			("175.777.950-70");
		aluno.setRg				("12312322");
		
		curso = new Curso();
		
		curso.setId(1);
		curso.setArea		("Exatas");
		curso.setNivel		("Graduação");
		curso.setNome		("Ciência da Computação");
		curso.setSigla		("CP");
		curso.setId			(1);
		
		rdm = new RDM();
		rdm.setId(3);
		rdm.setAluno(aluno);
		rdm.setAno(2010);
		rdm.setCurso(curso);
		rdm.setPeriodo(1);
	}

	@Test
	public void testRDM() {
		assertEquals(3				, rdm.getId(), 0);
		assertEquals(2010			, rdm.getAno(), 0);
		assertEquals(1				, rdm.getPeriodo());
		assertEquals(aluno			, rdm.getAluno());
		assertEquals(curso			, rdm.getCurso());
		assertEquals("GCP-101016"	, rdm.getMatricula());
		assertEquals("1757"			, rdm.getSenha());
		
		aluno.setId(3);
		rdm.setAluno(aluno);
		assertEquals("GCP-101003"	, rdm.getMatricula());
		
		aluno.setId(101);
		rdm.setAluno(aluno);
		assertEquals("GCP-101101"	, rdm.getMatricula());
		
		rdm.setMatricula("GCP-101003");
		assertEquals("GCP-101003"	, rdm.getMatricula());
		
		rdm.setSenha("1234");
		assertEquals("1234"			, rdm.getSenha());
	}

}
