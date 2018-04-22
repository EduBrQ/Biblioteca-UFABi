package com.web.test.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.AlunoDAO;
import com.web.dao.CursoDAO;
import com.web.dao.RDMDAO;
import com.web.model.Aluno;
import com.web.model.Curso;
import com.web.model.RDM;

public class RDMDAOTest {

	RDMDAO rdmDAO = new RDMDAO();
	RDM rdm;
	
	AlunoDAO alunoDAO = new AlunoDAO();
	Aluno aluno;
	
	CursoDAO cursoDAO = new CursoDAO();
	Curso curso;
	
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno();
		
		aluno.setId				(1);
		aluno.setNomeCompleto	("Nome completo do cidadao");
		aluno.setEndereco		("Rua do aluno");
		aluno.setTelefone		("(83)9.8888-8888");
		aluno.setNaturalidade	("Marte");
		aluno.setNomeMae		("Nome da mae completo");
		aluno.setNomePai		("Nome do pai completo");
		aluno.setCpf			("175.777.950-70");
		aluno.setRg				("12312322");
		
		alunoDAO.addAluno(aluno);
		
		curso = new Curso();
		
		curso.setId(1);
		curso.setArea		("Exatas");
		curso.setNivel		("Graduação");
		curso.setNome		("Ciência da Computação");
		curso.setSigla		("CP");
		curso.setId			(1);
		
		cursoDAO.addCurso(curso);
		
		rdm = new RDM();
		rdm.setId(3);
		rdm.setAluno(aluno);
		rdm.setAno(2010);
		rdm.setCurso(curso);
		rdm.setPeriodo(1);
		
		
	}

	@Test
	public void testRDMDAO() {
		RDM rdmTest = new RDM();
		
		// Testando o addRDM
		rdmDAO.addRDM(rdm, aluno, curso);
		
		// Testando o getRDM
		rdmTest = rdmDAO.getRDMById(1);
		assertEquals(1							, rdmTest.getId(), 0);
		assertEquals(2010						, rdmTest.getAno(), 0);
		assertEquals(1							, rdmTest.getPeriodo());
		assertEquals(aluno.getCpf()				, rdmTest.getAluno().getCpf());
		assertEquals(curso.getNome()			, rdmTest.getCurso().getNome());
		assertEquals("GCP-101001"				, rdmTest.getMatricula());
		assertEquals("1757"						, rdmTest.getSenha());
		System.out.println(rdmTest.getMatricula());
		
		// Testando o update
		RDM newRDM = new RDM();
		Aluno aluno2 = new Aluno();
		aluno2.setId				(1);
		aluno2.setNomeCompleto	("Outro aluno desconhecido");
		aluno2.setEndereco		("Rua do aluno doido");
		aluno2.setTelefone		("(83)9.8888-1234");
		aluno2.setNaturalidade	("Marte");
		aluno2.setNomeMae		("Nome da mae completo");
		aluno2.setNomePai		("Nome do pai completo");
		aluno2.setCpf			("175.777.950-70");
		aluno2.setRg				("12312322");
		
		Curso curso2 = new Curso();
		curso2.setId(1);
		curso2.setArea		("Humanas");
		curso2.setNivel		("Graduação");
		curso2.setNome		("Historia");
		curso2.setSigla		("HI");
		curso2.setId			(1);
		
		newRDM.setAluno(aluno2);
		newRDM.setAno(2012);
		newRDM.setCurso(curso2);
		newRDM.setPeriodo(2);
		
		rdmDAO.updateRDM(newRDM, rdm);
		
		rdmTest = rdmDAO.getRDMById(1);
		assertEquals(1							, rdmTest.getId(), 0);
		assertEquals(2012						, rdmTest.getAno(), 0);
		assertEquals(2							, rdmTest.getPeriodo());
		assertEquals(aluno2.getNomeCompleto()	, rdmTest.getAluno().getNomeCompleto());
		assertEquals(curso2.getNome()			, rdmTest.getCurso().getNome());
		assertEquals("GHI-122001"				, rdmTest.getMatricula());
		assertEquals("1757"						, rdmTest.getSenha());
		
		System.out.println(rdmTest.getMatricula());
	}

}
