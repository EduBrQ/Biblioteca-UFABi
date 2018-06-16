package com.uepb.ControleBiblioteca.test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.uepb.ControleBiblioteca.entities.TrabalhosDeConclusao;
import com.uepb.ControleBiblioteca.repository.TrabalhosDeConclusaoRepository;
import com.uepb.ControleBiblioteca.services.TrabalhosDeConclusaoService;

@RunWith(SpringRunner.class)
public class TrabalhoConclusaoServiceTest {

	@Mock
	private TrabalhosDeConclusaoService trabalhosDeConclusaoService;

	@Mock
	private TrabalhosDeConclusaoRepository trabalhosDeConclusaoRepository;

	@Before
	public void setUp() {
		trabalhosDeConclusaoRepository = mock(TrabalhosDeConclusaoRepository.class);
		trabalhosDeConclusaoService = new TrabalhosDeConclusaoService(trabalhosDeConclusaoRepository);
	}

	@Test
	public void addNewTrabalhosDeConclusaoServiceTest() {
		TrabalhosDeConclusao trabalhosDeConclusao = new TrabalhosDeConclusao(1L, 1, "Casos de estudo");
		trabalhosDeConclusaoService.create(trabalhosDeConclusao);
		ArgumentCaptor<TrabalhosDeConclusao> trabalhosDeConclusaoArgument = ArgumentCaptor.forClass(TrabalhosDeConclusao.class);
		verify(trabalhosDeConclusaoRepository, times(1)).save(trabalhosDeConclusaoArgument.capture());
		verifyNoMoreInteractions(trabalhosDeConclusaoRepository);
		TrabalhosDeConclusao model = trabalhosDeConclusaoArgument.getValue();
		assertThat(model.getTipoTcc(), is(trabalhosDeConclusao.getTipoTcc()));
		assertThat(model.getId(), is(trabalhosDeConclusao.getId()));
		assertThat(model.getTitulo(), is(trabalhosDeConclusao.getTitulo()));

	}

	@Test
	public void deleteServiceTest() {
		TrabalhosDeConclusao trabalhosDeConclusao = new TrabalhosDeConclusao(1L, 1, "Casos de estudo");
		when(trabalhosDeConclusaoRepository.getOne(1L)).thenReturn(trabalhosDeConclusao);
		trabalhosDeConclusaoRepository.deleteById(1L);
		verify(trabalhosDeConclusaoRepository, times(1)).deleteById(1L);
		verifyNoMoreInteractions(trabalhosDeConclusaoRepository);
	}

	@Test
	public void findAllServiceTest() {
		List<TrabalhosDeConclusao> models = new ArrayList<>();
		when(trabalhosDeConclusaoRepository.findAll()).thenReturn(models);
		List<TrabalhosDeConclusao> actual = trabalhosDeConclusaoService.findAll();
		verify(trabalhosDeConclusaoRepository, times(1)).findAll();
		verifyNoMoreInteractions(trabalhosDeConclusaoRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		TrabalhosDeConclusao trabalhosDeConclusao = new TrabalhosDeConclusao(1L, 1, "Casos de estudo");
		when(trabalhosDeConclusaoRepository.getOne(1L)).thenReturn(trabalhosDeConclusao);
		TrabalhosDeConclusao actual = trabalhosDeConclusaoRepository.getOne(1L);
		verify(trabalhosDeConclusaoRepository, times(1)).getOne(1L);
		verifyNoMoreInteractions(trabalhosDeConclusaoRepository);
		assertThat(actual, is(trabalhosDeConclusao));
	}
}
