package com.uepb.controlebiblioteca.test;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

import com.uepb.controlebiblioteca.controller.AnaisCongressoController;
import com.uepb.controlebiblioteca.model.AnaisCongresso;
import com.uepb.controlebiblioteca.service.AnaisCongressoService;
import com.uepb.controlebiblioteca.util.Principal;

import static org.mockito.Mockito.*;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = BaseTestConfig.class)
//@WithMockUser(username = "treze", roles = { "USER", "ADMIN" })

public class AnaisCongressoControllerTest {
	
//	@InjectMocks
//	AnaisCongressoController anaisCongressoController;
//	
//	@Mock
//	AnaisCongressoService anaisCongressoService;
//	
//	@Spy
//	List<AnaisCongresso> anaisCongressos = new ArrayList<AnaisCongresso>();
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
//		 MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.webAppContextSetup(wac).defaultRequest(get("/")).apply(springSecurity()).build();
//	}

//	@Test
//	public void testAllAnaisCongressos() throws Exception {
//        List<AnaisCongresso> users = Arrays.asList(
//                new AnaisCongresso(1, "Daenerys", "rtetr", "3544"),
//                new AnaisCongresso(1, "Targaryen", "rtetr", "3544"));
//        
//        when(anaisCongressoService.getAllAnaisCongressos()).thenReturn(users);
//
//        
//	    mockMvc.perform(get("/anaisCongresso"))
//	            .andExpect(status().isOk())
//	            .andExpect(view().name("anaisCongresso/index"))
//	            .andExpect(forwardedUrl("/WEB-INF/pages/anaisCongresso/index.jsp"))
//	            .andExpect(model().attribute("listAnaisCongresso", hasSize(2)))
//	            .andExpect(model().attribute("listAnaisCongresso", hasItem(
//                        allOf(
//                                hasProperty("id", is(1)),
//                                hasProperty("local", is("234")),
//                                hasProperty("nomeCongresso", is("43")),
//                                hasProperty("tipo", is("124"))
//                        )
//                )))
//	            .andExpect(model().attribute("listAnaisCongresso", hasItem(
//                        allOf(
//                                hasProperty("id", is(2)),
//                                hasProperty("local", is("234")),
//                                hasProperty("nomeCongresso", is("43")),
//                                hasProperty("tipo", is("124"))
//                        )
//                )));
//	    
////	       verify(anaisCongressoService, times(1)).getAllAnaisCongressos();
//	        verifyNoMoreInteractions(anaisCongressoService);
//	}

//	@Test
//	public void testNewContact() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSaveAnaisCongresso() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteAnaisCongresso() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEditContact() {
//		fail("Not yet implemented");
//	}


}
