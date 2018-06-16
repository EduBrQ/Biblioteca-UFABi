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
import com.uepb.ControleBiblioteca.controller.LivrosController;
import com.uepb.ControleBiblioteca.entities.Livros;
import com.uepb.ControleBiblioteca.services.LivrosService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LivrosController.class)
public class LivroControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private LivrosService livrosService;
	
	@Test
	public void findAllTest() throws Exception {
		Livros livros1 = new Livros(1L, "A SENHORA", "8iu8");
		List<Livros> mockPeople = Arrays.asList(livros1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockLivrosJSON = ow.writeValueAsString(mockPeople);	
		when(livrosService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/livros")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockLivrosJSON));
	}
	
	
	@Test
	public void findOneTest() throws Exception {
		   Livros livros1 = new Livros();
	       mock.perform(get("/livros" + "/{id}", livros1.getId())
	               .contentType(MediaType.APPLICATION_JSON_UTF8))
	               .andExpect(status().isOk());
	}
	
	

	@Test
	public void createNewLivrosTest() throws Exception {
		Livros mockLivros = new Livros(1L, "A SENHORA", "8iu8");
		when(livrosService.create(any(Livros.class))).thenReturn(mockLivros);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockLivrosJSON = ow.writeValueAsString(mockLivros);
		mock.perform(post("/livros")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockLivrosJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockLivrosJSON));
		verify(livrosService).create(any(Livros.class));		
	}
	
	@Test
	public void removeLivros() throws Exception {
		mock.perform(delete("/livros" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	@Test
	public void createNewLivrosAndFailTest() throws Exception {
		Livros mockLivros = new Livros(1L, "A SENHORA", "8iu8");
		when(livrosService.create(any(Livros.class))).thenReturn(mockLivros);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockLivros);
		mock.perform(post("/livros")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
		.andExpect(status().is(200));
	}
}

