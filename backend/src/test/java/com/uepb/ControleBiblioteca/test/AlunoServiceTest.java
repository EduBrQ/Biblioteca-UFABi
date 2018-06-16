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

import com.uepb.ControleBiblioteca.entities.Aluno;
import com.uepb.ControleBiblioteca.repository.AlunoRepository;
import com.uepb.ControleBiblioteca.services.AlunoService;

@RunWith(SpringRunner.class)
public class AlunoServiceTest {

	@Mock
	private AlunoService alunoService;

	@Mock
	private AlunoRepository alunoRepository;

	@Before
	public void setUp() {
		alunoRepository = mock(AlunoRepository.class);
		alunoService = new AlunoService(alunoRepository);
	}

	@Test
	public void addNewAlunoServiceTest() {
		Aluno aluno = new Aluno(1L, "5656", "6655", "Thiago");
		alunoService.create(aluno);
		ArgumentCaptor<Aluno> alunoArgument = ArgumentCaptor.forClass(Aluno.class);
		verify(alunoRepository, times(1)).save(alunoArgument.capture());
		verifyNoMoreInteractions(alunoRepository);
		Aluno model = alunoArgument.getValue();
		assertThat(model.getNome(), is(aluno.getNome()));
		assertThat(model.getId(), is(aluno.getId()));
		assertThat(model.getCpf(), is(aluno.getCpf()));
		assertThat(model.getMatricula(), is(aluno.getMatricula()));
	}

	@Test
	public void deleteServiceTest() {
		Aluno aluno = new Aluno(1L, "5656", "6655", "Thiago");
		when(alunoRepository.getOne(1L)).thenReturn(aluno);
		alunoRepository.deleteById(1L);
		verify(alunoRepository, times(1)).deleteById(1L);
		verifyNoMoreInteractions(alunoRepository);
	}

	@Test
	public void findAllServiceTest() {
		List<Aluno> models = new ArrayList<>();
		when(alunoRepository.findAll()).thenReturn(models);
		List<Aluno> actual = alunoService.findAll();
		verify(alunoRepository, times(1)).findAll();
		verifyNoMoreInteractions(alunoRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		Aluno aluno = new Aluno(1L, "5656", "6655", "Thiago");
		when(alunoRepository.getOne(1L)).thenReturn(aluno);
		Aluno actual = alunoRepository.getOne(1L);
		verify(alunoRepository, times(1)).getOne(1L);
		verifyNoMoreInteractions(alunoRepository);
		assertThat(actual, is(aluno));
	}
}
