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
import com.uepb.ControleBiblioteca.controller.AnaisDeCongressoController;
import com.uepb.ControleBiblioteca.entities.AnaisDeCongresso;
import com.uepb.ControleBiblioteca.services.AnaisDeCongressoService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AnaisDeCongressoController.class)
public class AnaisDeCongressoControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private AnaisDeCongressoService anaisDeCongressoService;
	
	@Test
	public void findAllTest() throws Exception {
		AnaisDeCongresso anaisDeCongresso1 =
				new AnaisDeCongresso(1L, "Congresso A", "Campina Grande");
		List<AnaisDeCongresso> mockPeople = Arrays.asList(anaisDeCongresso1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockAnaisDeCongressoJSON = ow.writeValueAsString(mockPeople);	
		when(anaisDeCongressoService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/anaisDeCongresso")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockAnaisDeCongressoJSON));
	}
	
	
	@Test
	public void findOneTest() throws Exception {
		   AnaisDeCongresso anaisDeCongresso1 = new AnaisDeCongresso();
	       mock.perform(get("/anaisDeCongresso" + "/{id}", anaisDeCongresso1.getId())
	               .contentType(MediaType.APPLICATION_JSON_UTF8))
	               .andExpect(status().isOk());
	}
	
	

	@Test
	public void createNewAnaisDeCongressoTest() throws Exception {
		AnaisDeCongresso mockAnaisDeCongresso = new AnaisDeCongresso(1L, "Congresso A", "Campina Grande");
		when(anaisDeCongressoService.create(any(AnaisDeCongresso.class))).thenReturn(mockAnaisDeCongresso);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockAnaisDeCongressoJSON = ow.writeValueAsString(mockAnaisDeCongresso);
		mock.perform(post("/anaisDeCongresso")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockAnaisDeCongressoJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockAnaisDeCongressoJSON));
		verify(anaisDeCongressoService).create(any(AnaisDeCongresso.class));		
	}
	
	@Test
	public void removeAnaisDeCongresso() throws Exception {
		mock.perform(delete("/anaisDeCongresso" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	@Test
	public void createNewAnaisDeCongressoAndFailTest() throws Exception {
		AnaisDeCongresso mockAnaisDeCongresso = new AnaisDeCongresso(1L, "Congresso A", "Campina Grande");
		when(anaisDeCongressoService.create(any(AnaisDeCongresso.class))).thenReturn(mockAnaisDeCongresso);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockAnaisDeCongresso);
		mock.perform(post("/anaisDeCongresso")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
		.andExpect(status().is(200));
	}
}

