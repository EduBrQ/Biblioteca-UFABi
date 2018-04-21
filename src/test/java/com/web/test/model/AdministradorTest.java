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
		admin.setFirstname("Admin");
		admin.setLastname("SobreNome do Admin");
		admin.setAddress("Rua do administrador");
		
		// O nivel de acesso � definido automaticamente, portanto n�o � necessario testar
	}

	@Test
	public void testGetters() {
		assertEquals("Admin", 						admin.getFirstname());
		assertEquals("SobreNome do Admin", 			admin.getLastname());
		assertEquals("Admin SobreNome do Admin", 	admin.getFullName());
		assertEquals(1, 							admin.getNivelAcesso(), 0);
	}
	
}
