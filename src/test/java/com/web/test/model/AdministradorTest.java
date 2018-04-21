package com.web.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Administrador;

public class AdministradorTest {

	Administrador admin;
	
	
	@Before
	public void setUp() throws Exception {
		admin = new Administrador();
		
		/* Setters **/
		admin.setFirstname	("Admin");
		admin.setLastname	("SobreNome do Admin");
		admin.setAddress	("Rua do administrador");
		admin.setId			(2);
		// O nivel de acesso é definido automaticamente, portanto não é necessario testar
	}

	@Test
	public void testGetters() {
		assertEquals(2								, admin.getId(), 0);
		assertEquals("Admin"						, admin.getFirstname());
		assertEquals("SobreNome do Admin"			, admin.getLastname());
		assertEquals("Admin SobreNome do Admin"		, admin.getFullName());
		assertEquals("Rua do administrador"			, admin.getAddress());
		assertEquals(1								, admin.getNivelAcesso(), 0);
	}
	
}
