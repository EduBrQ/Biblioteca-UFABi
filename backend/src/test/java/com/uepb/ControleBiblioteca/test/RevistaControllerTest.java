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
import com.uepb.ControleBiblioteca.controller.RevistasController;
import com.uepb.ControleBiblioteca.entities.Revistas;
import com.uepb.ControleBiblioteca.services.RevistasService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RevistasController.class)
public class RevistaControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private RevistasService revistasService;
	
	@Test
	public void findAllTest() throws Exception {
		Revistas revistas1 = new Revistas(1L, 1, "Casos de estudo");
		List<Revistas> mockPeople = Arrays.asList(revistas1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockRevistasJSON = ow.writeValueAsString(mockPeople);	
		when(revistasService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/revistas")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockRevistasJSON));
	}
	
	
	@Test
	public void findOneTest() throws Exception {
		   Revistas revistas1 = new Revistas();
	       mock.perform(get("/revistas" + "/{id}", revistas1.getId())
	               .contentType(MediaType.APPLICATION_JSON_UTF8))
	               .andExpect(status().isOk());
	}
	
	

	@Test
	public void createNewRevistasTest() throws Exception {
		Revistas mockRevistas = new Revistas(1L, 1, "Casos de estudo");
		when(revistasService.create(any(Revistas.class))).thenReturn(mockRevistas);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockRevistasJSON = ow.writeValueAsString(mockRevistas);
		mock.perform(post("/revistas")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockRevistasJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockRevistasJSON));
		verify(revistasService).create(any(Revistas.class));		
	}
	
	@Test
	public void removeRevistas() throws Exception {
		mock.perform(delete("/revistas" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	@Test
	public void createNewRevistasAndFailTest() throws Exception {
		Revistas mockRevistas = new Revistas(1L, 1, "Casos de estudo");
		when(revistasService.create(any(Revistas.class))).thenReturn(mockRevistas);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockRevistas);
		mock.perform(post("/revistas")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
		.andExpect(status().is(200));
	}
}

