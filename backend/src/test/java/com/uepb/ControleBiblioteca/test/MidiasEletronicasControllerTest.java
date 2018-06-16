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
import com.uepb.ControleBiblioteca.controller.MidiasEletronicasController;
import com.uepb.ControleBiblioteca.entities.MidiasEletronicas;
import com.uepb.ControleBiblioteca.services.MidiasEletronicasService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MidiasEletronicasController.class)
public class MidiasEletronicasControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private MidiasEletronicasService midiasEletronicasService;
	
	@Test
	public void findAllTest() throws Exception {
		MidiasEletronicas midiasEletronicas1 = new MidiasEletronicas(1L, "calypso", "cd");
		List<MidiasEletronicas> mockPeople = Arrays.asList(midiasEletronicas1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockMidiasEletronicasJSON = ow.writeValueAsString(mockPeople);	
		when(midiasEletronicasService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/midiasEletronicas")
					.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(200))
		.andExpect(content().json(mockMidiasEletronicasJSON));
	}
	
	
	@Test
	public void findOneTest() throws Exception {
		   MidiasEletronicas midiasEletronicas1 = new MidiasEletronicas();
	       mock.perform(get("/midiasEletronicas" + "/{id}", midiasEletronicas1.getId())
	               .contentType(MediaType.APPLICATION_JSON_UTF8))
	               .andExpect(status().isOk());
	}
	
	

	@Test
	public void createNewMidiasEletronicasTest() throws Exception {
		MidiasEletronicas mockMidiasEletronicas = new MidiasEletronicas(1L, "calypso", "cd");
		when(midiasEletronicasService.create(any(MidiasEletronicas.class))).thenReturn(mockMidiasEletronicas);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockMidiasEletronicasJSON = ow.writeValueAsString(mockMidiasEletronicas);
		mock.perform(post("/midiasEletronicas")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.content(mockMidiasEletronicasJSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mockMidiasEletronicasJSON));
		verify(midiasEletronicasService).create(any(MidiasEletronicas.class));		
	}
	
	@Test
	public void removeMidiasEletronicas() throws Exception {
		mock.perform(delete("/midiasEletronicas" + "/{id}", new Long(1)))
			.andExpect(status().is(200));
	}
	
	@Test
	public void createNewMidiasEletronicasAndFailTest() throws Exception {
		MidiasEletronicas mockMidiasEletronicas = new MidiasEletronicas(1L, "calypso", "cd");
		when(midiasEletronicasService.create(any(MidiasEletronicas.class))).thenReturn(mockMidiasEletronicas);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockMidiasEletronicas);
		mock.perform(post("/midiasEletronicas")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
		.andExpect(status().is(200));
	}
}

