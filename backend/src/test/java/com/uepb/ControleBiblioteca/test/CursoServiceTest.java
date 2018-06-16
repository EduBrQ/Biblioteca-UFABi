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

import com.uepb.ControleBiblioteca.entities.Curso;
import com.uepb.ControleBiblioteca.repository.CursoRepository;
import com.uepb.ControleBiblioteca.services.CursoService;

@RunWith(SpringRunner.class)
public class CursoServiceTest {

	@Mock
	private CursoService cursoService;

	@Mock
	private CursoRepository cursoRepository;

	@Before
	public void setUp() {
		cursoRepository = mock(CursoRepository.class);
		cursoService = new CursoService(cursoRepository);
	}

	@Test
	public void addNewCursoServiceTest() {
		Curso curso = new Curso(1L, "Matemática", "Exatas");
		cursoService.create(curso);
		ArgumentCaptor<Curso> cursoArgument = ArgumentCaptor.forClass(Curso.class);
		verify(cursoRepository, times(1)).save(cursoArgument.capture());
		verifyNoMoreInteractions(cursoRepository);
		Curso model = cursoArgument.getValue();
		assertThat(model.getNome(), is(curso.getNome()));
		assertThat(model.getId(), is(curso.getId()));
		assertThat(model.getArea(), is(curso.getArea()));

	}

	@Test
	public void deleteServiceTest() {
		Curso curso = new Curso(1L, "Matemática", "Exatas");
		when(cursoRepository.getOne(1L)).thenReturn(curso);
		cursoRepository.deleteById(1L);
		verify(cursoRepository, times(1)).deleteById(1L);
		verifyNoMoreInteractions(cursoRepository);
	}

	@Test
	public void findAllServiceTest() {
		List<Curso> models = new ArrayList<>();
		when(cursoRepository.findAll()).thenReturn(models);
		List<Curso> actual = cursoService.findAll();
		verify(cursoRepository, times(1)).findAll();
		verifyNoMoreInteractions(cursoRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		Curso curso = new Curso(1L, "Matemática", "Exatas");
		when(cursoRepository.getOne(1L)).thenReturn(curso);
		Curso actual = cursoRepository.getOne(1L);
		verify(cursoRepository, times(1)).getOne(1L);
		verifyNoMoreInteractions(cursoRepository);
		assertThat(actual, is(curso));
	}
}
