package com.uepb.controlebiblioteca.test;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.uepb.controlebiblioteca.controller.AlunoController;
import com.uepb.controlebiblioteca.model.Aluno;
import com.uepb.controlebiblioteca.service.AlunoService;
import com.uepb.controlebiblioteca.util.Principal;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;






//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = BaseTestConfig.class)
//@WithMockUser(username = "treze", roles = { "USER", "ADMIN" })

public class AlunoControllerTest {
	
//	@InjectMocks
//	AlunoController alunoController;
//	
//	@Mock
//	AlunoService alunoService;
//	
//	@Spy
//	List<Aluno> alunos = new ArrayList<Aluno>();
//	
//	@Spy
//	ModelAndView model;
//	
//	@Spy
//	Principal principal;
//	
//	
//	@Autowired
//	private WebApplicationContext wac;
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void init() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(wac).defaultRequest(get("/")).apply(springSecurity()).build();
//	}
//
//
//	@Test
//	public void testListAluno() throws Exception {
//		mockMvc.perform(get("/alunos")).andExpect(status().isOk()).andExpect(view().name("alunos/index"));
//		
//		
//
//	}
	
//	@Test
//	public void testAllAlunos() throws Exception {
//	    List<Aluno> alunos = getAlunoList();
//	    
//	    when(alunoService.getAllAlunos()).thenReturn(alunos);
//	    mockMvc.perform(get("/alunos"))
//	            .andExpect(status().isOk())
//	            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//	            .andExpect(jsonPath("$", hasSize(2)))
//	            .andExpect(jsonPath("$[0].id", is(1)))
//	            .andExpect(jsonPath("$[0].username", is("Daenerys Targaryen")))
//	            .andExpect(jsonPath("$[1].id", is(2)))
//	            .andExpect(jsonPath("$[1].username", is("John Snow")));
//	    verify(userService, times(1)).getAll();
//	    verifyNoMoreInteractions(userService);
//	}

//	@Test
//	public void testNewContact() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSaveAluno() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteAluno() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEditContact() {
//		fail("Not yet implemented");
//	}


}
