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
import com.uepb.ControleBiblioteca.controller.AlunoController;
import com.uepb.ControleBiblioteca.entities.Aluno;
import com.uepb.ControleBiblioteca.services.AlunoService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AlunoController.class)
public class AlunoControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private AlunoService alunoService;
	
	@Test
	public void findAllTest() throws Exception {
		Aluno aluno1 = new Aluno(1L, "5656", "6655", "Thiago");
		List<Aluno> mockPeople = Arrays.asList(aluno1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockAlunoJSON = ow.writeValueAsString(mockPeople);	
		when(alunoService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/alunos")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockAlunoJSON));
	}
	
	
	@Test
	public void findOneTest() throws Exception {
		   Aluno aluno1 = new Aluno();
	       mock.perform(get("/alunos" + "/{id}", aluno1.getId())
	               .contentType(MediaType.APPLICATION_JSON_UTF8))
	               .andExpect(status().isOk());
	}
	
	

	@Test
	public void createNewAlunoTest() throws Exception {
		Aluno mockAluno = new Aluno(1L, "5656", "6655", "Thiago");
		when(alunoService.create(any(Aluno.class))).thenReturn(mockAluno);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockAlunoJSON = ow.writeValueAsString(mockAluno);
		mock.perform(post("/alunos")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockAlunoJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockAlunoJSON));
		verify(alunoService).create(any(Aluno.class));		
	}
	
	@Test
	public void removeAluno() throws Exception {
		mock.perform(delete("/alunos" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	@Test
	public void createNewAlunoAndFailTest() throws Exception {
		Aluno mockAluno = new Aluno(1L, "5656", "6655", "Thiago");
		when(alunoService.create(any(Aluno.class))).thenReturn(mockAluno);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockAluno);
		mock.perform(post("/alunos")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
		.andExpect(status().is(200));
	}
}

