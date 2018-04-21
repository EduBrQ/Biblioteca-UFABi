package com.web.test.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.UserDAO;
import com.web.model.User;


public class UserDAOTest {

	UserDAO uDAO = new UserDAO();
	User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setFirstname("Nome");
		user.setLastname("SobreNome da Pessoa");
		user.setAddress("Rua Nome da rua");
		
	}
	
	@Test
	public void testUserDAO() {
		User userTest = new User();
		
		//Testando o addUser
		uDAO.addUser(this.user);
		
		//Testando o getUser
		userTest = uDAO.getUserById(1);
		assertEquals("Nome", 							userTest.getFirstname());
		assertEquals("SobreNome da Pessoa", 			userTest.getLastname());
		assertEquals("Nome SobreNome da Pessoa", 		userTest.getFullName());
		assertEquals("Rua Nome da rua", 				userTest.getAddress());
		assertEquals(2, 								userTest.getNivelAcesso(), 0);
		
		//Testando o update
		User newUser = new User();
		newUser.setFirstname("Nome");
		newUser.setLastname("SobreNome da Pessoa");
		newUser.setAddress("Mudei o nome da minha rua");
		uDAO.updateUser(newUser, user);
		userTest =  uDAO.getUserById(1);
		
		assertEquals("Nome", 							userTest.getFirstname());
		assertEquals("SobreNome da Pessoa", 			userTest.getLastname());
		assertEquals("Nome SobreNome da Pessoa", 		userTest.getFullName());
		assertEquals("Mudei o nome da minha rua", 		userTest.getAddress());
		assertNotEquals("Rua Nome da rua", 				userTest.getAddress());
		assertEquals(2, 								userTest.getNivelAcesso(), 0);
		
		// Testando o delete e verificando se ainda existe
		uDAO.deleteUser(1);
		userTest = uDAO.getUserById(1);
		
		assertEquals(null, 	userTest.getFirstname());
	}


}
