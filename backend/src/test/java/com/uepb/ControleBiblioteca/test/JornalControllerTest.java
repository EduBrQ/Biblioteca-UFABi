package com.uepb.ControleBiblioteca.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.uepb.ControleBiblioteca.controller.JornaisController;
import com.uepb.ControleBiblioteca.entities.Jornais;
import com.uepb.ControleBiblioteca.services.JornaisService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = JornaisController.class)
public class JornalControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private JornaisService jornaisService;
	
	@Test
	public void findAllTest() throws Exception {
		Jornais jornais1 = new Jornais(1L, "JPB", "Manhã");
		List<Jornais> mockPeople = Arrays.asList(jornais1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockJornaisJSON = ow.writeValueAsString(mockPeople);	
		when(jornaisService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/jornais")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockJornaisJSON));
	}
	
	
	@Test
	public void findOneTest() throws Exception {
		   Jornais jornais1 = new Jornais();
	       mock.perform(get("/jornais" + "/{id}", jornais1.getId())
	               .contentType(MediaType.APPLICATION_JSON_UTF8))
	               .andExpect(status().isOk());
	}
	
	

	@Test
	public void createNewJornaisTest() throws Exception {
		Jornais mockJornais = new Jornais(1L, "JPB", "Manhã");
		when(jornaisService.create(any(Jornais.class))).thenReturn(mockJornais);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockJornaisJSON = ow.writeValueAsString(mockJornais);
		mock.perform(post("/jornais")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockJornaisJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockJornaisJSON));
		verify(jornaisService).create(any(Jornais.class));		
	}
	
	@Test
	public void removeJornais() throws Exception {
		mock.perform(delete("/jornais" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	@Test
	public void createNewJornaisAndFailTest() throws Exception {
		Jornais mockJornais = new Jornais(1L, "JPB", "Manhã");
		when(jornaisService.create(any(Jornais.class))).thenReturn(mockJornais);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockJornais);
		mock.perform(post("/jornais")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
		.andExpect(status().is(200));
	}
}

