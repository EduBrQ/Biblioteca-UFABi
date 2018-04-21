package com.web.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.UserDAO;
import com.web.model.User;


public class UserDAOTest {

	UserDAO dao = new UserDAO();
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
		dao.addUser(this.user);
		
		//Testando o getUser
		userTest = dao.getUserById(1);
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
		dao.updateUser(newUser, user);
		userTest =  dao.getUserById(1);
		
		assertEquals("Nome", 							userTest.getFirstname());
		assertEquals("SobreNome da Pessoa", 			userTest.getLastname());
		assertEquals("Nome SobreNome da Pessoa", 		userTest.getFullName());
		assertEquals("Mudei o nome da minha rua", 		userTest.getAddress());
		assertNotEquals("Rua Nome da rua", 				userTest.getAddress());
		assertEquals(2, 								userTest.getNivelAcesso(), 0);
		
		// Testando o delete e verificando se ainda existe
		dao.deleteUser(1);
		userTest = dao.getUserById(1);
		
		assertEquals(null, 	userTest.getFirstname());
		
		// Testando o delete e verificando se ainda existe
		
		List<User> list = new ArrayList<User>();
		
		for(int i=0; i<5; i++) {
			list.add(this.user);
			dao.addUser(this.user);
		}
		
		List<User> list2 = dao.getAllUsers();
		
		for(int i=0; i<list.size(); i++) {
			assertEquals(list.get(i).getAddress(), list2.get(i).getAddress());
			assertEquals(list.get(i).getFirstname(), list2.get(i).getFirstname());
			assertEquals(list.get(i).getLastname(), list2.get(i).getLastname());
			assertEquals(list.get(i).getNivelAcesso(), list2.get(i).getNivelAcesso());
		}
	}


}
