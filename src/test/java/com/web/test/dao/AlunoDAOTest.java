package com.web.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.AlunoDAO;
import com.web.model.Aluno;

public class AlunoDAOTest {
	
	AlunoDAO dao = new AlunoDAO();
	Aluno aluno;
	
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno();
		
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
	public void test() {
		Aluno alunoTest = new Aluno();
		
		// Testando o addAluno
		dao.addAluno(this.aluno);
		
		// Testando o getAluno
		alunoTest = dao.getAlunoById(1);
		assertEquals(1								, alunoTest.getId(), 0);
		assertEquals("Nome completo do cidadao"		, alunoTest.getNomeCompleto());
		assertEquals("Rua do aluno"					, alunoTest.getEndereco());
		assertEquals("(83)9.8888-8888"				, alunoTest.getTelefone());
		assertEquals("Marte"						, alunoTest.getNaturalidade());
		assertEquals("Nome da mae completo"			, alunoTest.getNomeMae());
		assertEquals("Nome do pai completo"			, alunoTest.getNomePai());
		assertEquals("175.777.950-70"				, alunoTest.getCpf());		
		assertEquals("12312322"						, alunoTest.getRg());
		
		// Testando o update
		Aluno newAluno = new Aluno();
		newAluno.setNomeCompleto	("Nome completo do cidadao");
		newAluno.setEndereco		("Nova rua do aluno");
		newAluno.setTelefone		("(83)9.7777-7777");
		newAluno.setNaturalidade	("Venus");
		newAluno.setNomeMae			("Nome da mae completo");
		newAluno.setNomePai			("Nome do pai completo");
		newAluno.setCpf				("175.777.950-70"); // Precisa ser um cpf valido
		newAluno.setRg				("12312322");
		
		dao.updateAluno(newAluno, alunoTest);
		alunoTest = dao.getAlunoById(1);
		assertEquals(1								, alunoTest.getId(), 0);
		assertEquals("Nome completo do cidadao"		, alunoTest.getNomeCompleto());
		assertEquals("Nova rua do aluno"			, alunoTest.getEndereco());
		assertEquals("(83)9.7777-7777"				, alunoTest.getTelefone());
		assertEquals("Venus"						, alunoTest.getNaturalidade());
		assertEquals("Nome da mae completo"			, alunoTest.getNomeMae());
		assertEquals("Nome do pai completo"			, alunoTest.getNomePai());
		assertEquals("175.777.950-70"				, alunoTest.getCpf());		
		assertEquals("12312322"						, alunoTest.getRg());
		
		// Testando o delete e verificando se ainda existe
		
		dao.deleteAluno(aluno);
		alunoTest = dao.getAlunoById(1);
		
		assertEquals(null							, alunoTest.getCpf());
		
		// Testando pegando todos os alunos
		List<Aluno> list = new ArrayList<Aluno>();
		
		for(int i=0; i<5; i++) {
			list.add(this.aluno);
			dao.addAluno(this.aluno);
		}
		
		List<Aluno> list2 = dao.getAllAlunos();
		
		for(int i=0; i<list.size(); i++) {
			assertEquals(list.get(i).getCpf(), list2.get(i).getCpf());
			assertEquals(list.get(i).getEndereco(), list2.get(i).getEndereco());
			assertEquals(list.get(i).getNaturalidade(), list2.get(i).getNaturalidade());
			assertEquals(list.get(i).getNomeCompleto(), list2.get(i).getNomeCompleto());
			assertEquals(list.get(i).getNomeMae(), list2.get(i).getNomeMae());
			assertEquals(list.get(i).getNomePai(), list2.get(i).getNomePai());
			assertEquals(list.get(i).getRg(), list2.get(i).getRg());
			assertEquals(list.get(i).getTelefone(), list2.get(i).getTelefone());
		}
		
	}
	
	@Test
	public void testCompare() {
		// Compare TRUE
		Aluno aluno1 = new Aluno();
		aluno1.setNomeCompleto	("Nome completo do cidadao");
		aluno1.setEndereco		("Rua do aluno");
		aluno1.setTelefone		("(83)9.8888-8888");
		aluno1.setNaturalidade	("Marte");
		aluno1.setNomeMae		("Nome da mae completo");
		aluno1.setNomePai		("Nome do pai completo");
		aluno1.setCpf			("175.777.950-70"); // Precisa ser um cpf valido
		aluno1.setRg			("12312322");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNomeCompleto	("Nome completo do cidadao");
		aluno2.setEndereco		("Rua do aluno");
		aluno2.setTelefone		("(83)9.8888-8888");
		aluno2.setNaturalidade	("Marte");
		aluno2.setNomeMae		("Nome da mae completo");
		aluno2.setNomePai		("Nome do pai completo");
		aluno2.setCpf			("175.777.950-70"); // Precisa ser um cpf valido
		aluno2.setRg			("12312322");
		
		assertEquals(true, dao.compare(aluno1, aluno2));
		
		// Compare FALSE
		
		Aluno aluno3 = new Aluno();
		aluno3.setNomeCompleto	("Outro nome");
		aluno3.setEndereco		("Rua do aluno novo");
		aluno3.setTelefone		("(83)9.8888-7777");
		aluno3.setNaturalidade	("Marte");
		aluno3.setNomeMae		("Nome da mae completo");
		aluno3.setNomePai		("Nome do pai completo");
		aluno3.setCpf			("175.777.950-70"); // Precisa ser um cpf valido
		aluno3.setRg			("12312322");
		
		assertEquals(false, dao.compare(aluno2, aluno3));
	}

}
