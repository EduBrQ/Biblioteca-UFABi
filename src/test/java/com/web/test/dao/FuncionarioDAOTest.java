package com.web.test.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.FuncionarioDAO;
import com.web.model.Funcionario;

public class FuncionarioDAOTest {

	FuncionarioDAO dao = new FuncionarioDAO();
	Funcionario funcionario;
	
	@Before
	public void setUp() throws Exception {
		funcionario = new Funcionario();
		
		funcionario.setCpf				("767.298.550-70");
		funcionario.setEmail			("meuemail@email.com");
		funcionario.setEndereco			("Endereco do funcionario");
		funcionario.setNaturalidade		("Sol");
		funcionario.setNome				("Meu nome muito louco");
		funcionario.setTelefone			("(83)9.8888-8888");
	}

	@Test
	public void testFuncionarioDAO() throws IOException {
		Funcionario funcionarioTest = new Funcionario();
		
		// Testando addFuncionario
		dao.addFuncionario(this.funcionario);
		
		// Testando o getFuncionario
		funcionarioTest = dao.getFuncionarioById(1);
		assertEquals(1								, funcionarioTest.getId(), 0);
		assertEquals("767.298.550-70"				, funcionarioTest.getCpf());
		assertEquals("meuemail@email.com"			, funcionarioTest.getEmail());
		assertEquals("Endereco do funcionario"		, funcionarioTest.getEndereco());
		assertEquals("Sol"							, funcionarioTest.getNaturalidade());
		assertEquals("Meu nome muito louco"			, funcionarioTest.getNome());
		assertEquals("(83)9.8888-8888"				, funcionarioTest.getTelefone());
		assertEquals("7672"							, funcionarioTest.getSenha());
		
		// Testando o update
		Funcionario newFuncionario =  new Funcionario();
		newFuncionario.setCpf				("767.298.550-70");
		newFuncionario.setEmail				("mudeiemail@email.com");
		newFuncionario.setEndereco			("Minha outra casa");
		newFuncionario.setNaturalidade		("Mundo da lua");
		newFuncionario.setNome				("Meu nome muito louco");
		newFuncionario.setTelefone			("(83)9.8888-8888");
		
		dao.updateFuncionario(newFuncionario, funcionarioTest);
		funcionarioTest = dao.getFuncionarioById(1);
		assertEquals(1								, funcionarioTest.getId(), 0);
		assertEquals("767.298.550-70"				, funcionarioTest.getCpf());
		assertEquals("mudeiemail@email.com"			, funcionarioTest.getEmail());
		assertEquals("Minha outra casa"				, funcionarioTest.getEndereco());
		assertEquals("Mundo da lua"					, funcionarioTest.getNaturalidade());
		assertEquals("Meu nome muito louco"			, funcionarioTest.getNome());
		assertEquals("(83)9.8888-8888"				, funcionarioTest.getTelefone());
		assertEquals("7672"							, funcionarioTest.getSenha());
		
		// Testando o delete
		dao.deleteFuncionario(1);
		funcionarioTest = dao.getFuncionarioById(1);
		
		assertEquals(null							, funcionarioTest.getCpf());
		
		// Testando pegando todos os Funcionarios
		List<Funcionario> list = new ArrayList<Funcionario>();
		
		for(int i=0; i<5; i++) {
			list.add(this.funcionario);
			dao.addFuncionario(this.funcionario);
		}
		
		List<Funcionario> list2 = dao.getAllFuncionarios();
		
		for(int i=0; i<list.size(); i++) {
			assertEquals(list.get(i).getCpf()			, list2.get(i).getCpf());
			assertEquals(list.get(i).getEmail()			, list2.get(i).getEmail());
			assertEquals(list.get(i).getEndereco()		, list2.get(i).getEndereco());
			assertEquals(list.get(i).getNaturalidade()	, list2.get(i).getNaturalidade());
			assertEquals(list.get(i).getNome()			, list2.get(i).getNome());
			assertEquals(list.get(i).getSenha()			, list2.get(i).getSenha());
			assertEquals(list.get(i).getTelefone()		, list2.get(i).getTelefone());
		}
		
		
	}

}
