package com.uepb.controlebiblioteca.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = BaseTestConfig.class)
//@WithMockUser(username = "treze", roles = { "USER", "ADMIN" })
public class HomeControllerTest {
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
//	@Test
//	public void testHome() throws Exception {
//		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"));
//	}
//
//	@Test
//	public void testLogin() throws Exception {
//		mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login"));
//	}
//
//	@Test
//	public void testSignup() throws Exception {
//		mockMvc.perform(get("/signup")).andExpect(status().isOk()).andExpect(view().name("signup"));
//	}
}
