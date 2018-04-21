package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Funcionario;

public class FuncionarioTest {

	Funcionario funcionario;
	@Before
	public void setUp() throws Exception {
		funcionario = new Funcionario();
		
		funcionario.setId				(1);
		funcionario.setCpf				("767.298.550-70");
		funcionario.setEmail			("meuemail@email.com");
		funcionario.setEndereco			("Endereco do funcionario");
		funcionario.setNaturalidade		("Sol");
		funcionario.setNome				("Meu nome muito louco");
		funcionario.setTelefone			("(83)9.8888-8888");
		
		// A senha e definida pelos quatro primeiros numeros do cpf
	}

	@Test
	public void test() {
		
		assertEquals(1								, funcionario.getId(), 0);
		assertEquals("767.298.550-70"				, funcionario.getCpf());
		assertEquals("meuemail@email.com"			, funcionario.getEmail());
		assertEquals("Endereco do funcionario"		, funcionario.getEndereco());
		assertEquals("Sol"							, funcionario.getNaturalidade());
		assertEquals("Meu nome muito louco"			, funcionario.getNome());
		assertEquals("(83)9.8888-8888"				, funcionario.getTelefone());
		assertEquals("7672"							, funcionario.getSenha());
		
		funcionario.setSenha("1234");
		assertEquals("1234"							, funcionario.getSenha());
	}

}
