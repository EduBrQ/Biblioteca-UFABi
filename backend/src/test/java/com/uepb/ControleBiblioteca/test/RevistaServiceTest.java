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

import com.uepb.ControleBiblioteca.entities.Revistas;
import com.uepb.ControleBiblioteca.repository.RevistasRepository;
import com.uepb.ControleBiblioteca.services.RevistasService;

@RunWith(SpringRunner.class)
public class RevistaServiceTest {

	@Mock
	private RevistasService revistasService;

	@Mock
	private RevistasRepository revistasRepository;

	@Before
	public void setUp() {
		revistasRepository = mock(RevistasRepository.class);
		revistasService = new RevistasService(revistasRepository);
	}

	@Test
	public void addNewRevistasServiceTest() {
		Revistas revistas = new Revistas(1L, 1, "Casos de estudo");
		revistasService.create(revistas);
		ArgumentCaptor<Revistas> revistasArgument = ArgumentCaptor.forClass(Revistas.class);
		verify(revistasRepository, times(1)).save(revistasArgument.capture());
		verifyNoMoreInteractions(revistasRepository);
		Revistas model = revistasArgument.getValue();
		assertThat(model.getTitulo(), is(revistas.getTitulo()));
		assertThat(model.getNumeroPaginas(), is(revistas.getNumeroPaginas()));
		assertThat(model.getId(), is(revistas.getId()));
	}

	@Test
	public void deleteServiceTest() {
		Revistas revistas = new Revistas(1L, 1, "Casos de estudo");
		when(revistasRepository.getOne(1L)).thenReturn(revistas);
		revistasRepository.deleteById(1L);
		verify(revistasRepository, times(1)).deleteById(1L);
		verifyNoMoreInteractions(revistasRepository);
	}

	@Test
	public void findAllServiceTest() {
		List<Revistas> models = new ArrayList<>();
		when(revistasRepository.findAll()).thenReturn(models);
		List<Revistas> actual = revistasService.findAll();
		verify(revistasRepository, times(1)).findAll();
		verifyNoMoreInteractions(revistasRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		Revistas revistas = new Revistas(1L, 1, "Casos de estudo");
		when(revistasRepository.getOne(1L)).thenReturn(revistas);
		Revistas actual = revistasRepository.getOne(1L);
		verify(revistasRepository, times(1)).getOne(1L);
		verifyNoMoreInteractions(revistasRepository);
		assertThat(actual, is(revistas));
	}
}
