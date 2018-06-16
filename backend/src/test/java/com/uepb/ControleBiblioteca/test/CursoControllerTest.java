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
import com.uepb.ControleBiblioteca.controller.CursoController;
import com.uepb.ControleBiblioteca.entities.Curso;
import com.uepb.ControleBiblioteca.services.CursoService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CursoController.class)
public class CursoControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private CursoService cursoService;
	
	@Test
	public void findAllTest() throws Exception {
		Curso curso1 = new Curso(1L, "Matemática", "Exatas");
		List<Curso> mockPeople = Arrays.asList(curso1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockCursoJSON = ow.writeValueAsString(mockPeople);	
		when(cursoService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/cursos")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockCursoJSON));
	}
	
	
	@Test
	public void findOneTest() throws Exception {
		   Curso curso1 = new Curso();
	       mock.perform(get("/cursos" + "/{id}", curso1.getId())
	               .contentType(MediaType.APPLICATION_JSON_UTF8))
	               .andExpect(status().isOk());
	}
	
	

	@Test
	public void createNewCursoTest() throws Exception {
		Curso mockCurso = new Curso(1L, "Matemática", "Exatas");
		when(cursoService.create(any(Curso.class))).thenReturn(mockCurso);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockCursoJSON = ow.writeValueAsString(mockCurso);
		mock.perform(post("/cursos")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockCursoJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockCursoJSON));
		verify(cursoService).create(any(Curso.class));		
	}
	
	@Test
	public void removeCurso() throws Exception {
		mock.perform(delete("/cursos" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	@Test
	public void createNewCursoAndFailTest() throws Exception {
		Curso mockCurso = new Curso(1L, "Matemática", "Exatas");
		when(cursoService.create(any(Curso.class))).thenReturn(mockCurso);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockCurso);
		mock.perform(post("/cursos")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
		.andExpect(status().is(200));
	}
}

