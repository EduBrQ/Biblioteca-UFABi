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
import com.uepb.ControleBiblioteca.controller.TrabalhosDeConclusaoController;
import com.uepb.ControleBiblioteca.entities.TrabalhosDeConclusao;
import com.uepb.ControleBiblioteca.services.TrabalhosDeConclusaoService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TrabalhosDeConclusaoController.class)
public class TrabalhoConclusaoControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private TrabalhosDeConclusaoService trabalhosDeConclusaoService;
	
	@Test
	public void findAllTest() throws Exception {
		TrabalhosDeConclusao trabalhosDeConclusao1 = new TrabalhosDeConclusao(1L, 1, "Casos de estudo");
		List<TrabalhosDeConclusao> mockPeople = Arrays.asList(trabalhosDeConclusao1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockTrabalhosDeConclusaoJSON = ow.writeValueAsString(mockPeople);	
		when(trabalhosDeConclusaoService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/trabalhosDeConclusao")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockTrabalhosDeConclusaoJSON));
	}
	
	
	@Test
	public void findOneTest() throws Exception {
		   TrabalhosDeConclusao trabalhosDeConclusao1 = new TrabalhosDeConclusao();
	       mock.perform(get("/trabalhosDeConclusao" + "/{id}", trabalhosDeConclusao1.getId())
	               .contentType(MediaType.APPLICATION_JSON_UTF8))
	               .andExpect(status().isOk());
	}
	
	

	@Test
	public void createNewTrabalhosDeConclusaoTest() throws Exception {
		TrabalhosDeConclusao mockTrabalhosDeConclusao = new TrabalhosDeConclusao(1L, 1, "Casos de estudo");
		when(trabalhosDeConclusaoService.create(any(TrabalhosDeConclusao.class))).thenReturn(mockTrabalhosDeConclusao);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockTrabalhosDeConclusaoJSON = ow.writeValueAsString(mockTrabalhosDeConclusao);
		mock.perform(post("/trabalhosDeConclusao")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockTrabalhosDeConclusaoJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockTrabalhosDeConclusaoJSON));
		verify(trabalhosDeConclusaoService).create(any(TrabalhosDeConclusao.class));		
	}
	
	@Test
	public void removeTrabalhosDeConclusao() throws Exception {
		mock.perform(delete("/trabalhosDeConclusao" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	@Test
	public void createNewTrabalhosDeConclusaoAndFailTest() throws Exception {
		TrabalhosDeConclusao mockTrabalhosDeConclusao = new TrabalhosDeConclusao(1L, 1, "Casos de estudo");
		when(trabalhosDeConclusaoService.create(any(TrabalhosDeConclusao.class))).thenReturn(mockTrabalhosDeConclusao);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockTrabalhosDeConclusao);
		mock.perform(post("/trabalhosDeConclusao")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
		.andExpect(status().is(200));
	}
}

