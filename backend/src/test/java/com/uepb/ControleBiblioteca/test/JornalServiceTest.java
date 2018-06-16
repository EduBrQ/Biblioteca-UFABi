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

import com.uepb.ControleBiblioteca.entities.Jornais;
import com.uepb.ControleBiblioteca.repository.JornaisRepository;
import com.uepb.ControleBiblioteca.services.JornaisService;

@RunWith(SpringRunner.class)
public class JornalServiceTest {

	@Mock
	private JornaisService jornaisService;

	@Mock
	private JornaisRepository jornaisRepository;

	@Before
	public void setUp() {
		jornaisRepository = mock(JornaisRepository.class);
		jornaisService = new JornaisService(jornaisRepository);
	}

	@Test
	public void addNewJornaisServiceTest() {
		Jornais jornais = new Jornais(1L, "JPB", "Manhã");
		jornaisService.create(jornais);
		ArgumentCaptor<Jornais> jornaisArgument = ArgumentCaptor.forClass(Jornais.class);
		verify(jornaisRepository, times(1)).save(jornaisArgument.capture());
		verifyNoMoreInteractions(jornaisRepository);
		Jornais model = jornaisArgument.getValue();
		assertThat(model.getTitulo(), is(jornais.getTitulo()));
		assertThat(model.getId(), is(jornais.getId()));
		assertThat(model.getEdicao(), is(jornais.getEdicao()));

	}

	@Test
	public void deleteServiceTest() {
		Jornais jornais = new Jornais(1L, "JPB", "Manhã");
		when(jornaisRepository.getOne(1L)).thenReturn(jornais);
		jornaisRepository.deleteById(1L);
		verify(jornaisRepository, times(1)).deleteById(1L);
		verifyNoMoreInteractions(jornaisRepository);
	}

	@Test
	public void findAllServiceTest() {
		List<Jornais> models = new ArrayList<>();
		when(jornaisRepository.findAll()).thenReturn(models);
		List<Jornais> actual = jornaisService.findAll();
		verify(jornaisRepository, times(1)).findAll();
		verifyNoMoreInteractions(jornaisRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		Jornais jornais = new Jornais(1L, "JPB", "Manhã");
		when(jornaisRepository.getOne(1L)).thenReturn(jornais);
		Jornais actual = jornaisRepository.getOne(1L);
		verify(jornaisRepository, times(1)).getOne(1L);
		verifyNoMoreInteractions(jornaisRepository);
		assertThat(actual, is(jornais));
	}
}
