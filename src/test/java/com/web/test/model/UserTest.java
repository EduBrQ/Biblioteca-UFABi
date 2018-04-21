package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.User;

public class UserTest {

	User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User();
		
		/* Setters **/
		user.setFirstname		("Primeiro");
		user.setLastname		("SobreNome da Pessoa");
		user.setAddress			("Rua minha rua ao quadrado");
		user.setId				(1);
		// O nivel de acesso é definido automaticamente, portanto não é necessario testar

	}
	
	@Test
	public void testGetters() {
		assertEquals(1									, user.getId(), 0);
		assertEquals("Primeiro"							, user.getFirstname());
		assertEquals("SobreNome da Pessoa"				, user.getLastname());
		assertEquals("Primeiro SobreNome da Pessoa"		, user.getFullName());
		assertEquals("Rua minha rua ao quadrado"		, user.getAddress());
		assertEquals(2									, user.getNivelAcesso(),0); // Testa se o nivel de acesso esta correto
	}

}
