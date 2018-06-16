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

import com.uepb.ControleBiblioteca.entities.Livros;
import com.uepb.ControleBiblioteca.repository.LivrosRepository;
import com.uepb.ControleBiblioteca.services.LivrosService;

@RunWith(SpringRunner.class)
public class LivroServiceTest {

	@Mock
	private LivrosService livrosService;

	@Mock
	private LivrosRepository livrosRepository;

	@Before
	public void setUp() {
		livrosRepository = mock(LivrosRepository.class);
		livrosService = new LivrosService(livrosRepository);
	}

	@Test
	public void addNewLivrosServiceTest() {
		Livros livros = new Livros(1L, "A SENHORA", "8iu8");
		livrosService.create(livros);
		ArgumentCaptor<Livros> livrosArgument = ArgumentCaptor.forClass(Livros.class);
		verify(livrosRepository, times(1)).save(livrosArgument.capture());
		verifyNoMoreInteractions(livrosRepository);
		Livros model = livrosArgument.getValue();
		assertThat(model.getISBN(), is(livros.getISBN()));
		assertThat(model.getId(), is(livros.getId()));
		assertThat(model.getTitulo(), is(livros.getTitulo()));

	}

	@Test
	public void deleteServiceTest() {
		Livros livros = new Livros(1L, "A SENHORA", "8iu8");
		when(livrosRepository.getOne(1L)).thenReturn(livros);
		livrosRepository.deleteById(1L);
		verify(livrosRepository, times(1)).deleteById(1L);
		verifyNoMoreInteractions(livrosRepository);
	}

	@Test
	public void findAllServiceTest() {
		List<Livros> models = new ArrayList<>();
		when(livrosRepository.findAll()).thenReturn(models);
		List<Livros> actual = livrosService.findAll();
		verify(livrosRepository, times(1)).findAll();
		verifyNoMoreInteractions(livrosRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		Livros livros = new Livros(1L, "A SENHORA", "8iu8");
		when(livrosRepository.getOne(1L)).thenReturn(livros);
		Livros actual = livrosRepository.getOne(1L);
		verify(livrosRepository, times(1)).getOne(1L);
		verifyNoMoreInteractions(livrosRepository);
		assertThat(actual, is(livros));
	}
}
