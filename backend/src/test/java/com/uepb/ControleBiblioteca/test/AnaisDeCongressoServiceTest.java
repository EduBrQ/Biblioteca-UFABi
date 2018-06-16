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

import com.uepb.ControleBiblioteca.entities.AnaisDeCongresso;
import com.uepb.ControleBiblioteca.repository.AnaisDeCongressoRepository;
import com.uepb.ControleBiblioteca.services.AnaisDeCongressoService;

@RunWith(SpringRunner.class)
public class AnaisDeCongressoServiceTest {

	@Mock
	private AnaisDeCongressoService anaisDeCongressoService;

	@Mock
	private AnaisDeCongressoRepository anaisDeCongressoRepository;

	@Before
	public void setUp() {
		anaisDeCongressoRepository = mock(AnaisDeCongressoRepository.class);
		anaisDeCongressoService = new AnaisDeCongressoService(anaisDeCongressoRepository);
	}

	@Test
	public void addNewAnaisDeCongressoServiceTest() {
		AnaisDeCongresso anaisDeCongresso = new AnaisDeCongresso(1L, "Congresso A", "Campina Grande");
		anaisDeCongressoService.create(anaisDeCongresso);
		ArgumentCaptor<AnaisDeCongresso> anaisDeCongressoArgument = ArgumentCaptor.forClass(AnaisDeCongresso.class);
		verify(anaisDeCongressoRepository, times(1)).save(anaisDeCongressoArgument.capture());
		verifyNoMoreInteractions(anaisDeCongressoRepository);
		AnaisDeCongresso model = anaisDeCongressoArgument.getValue();
		assertThat(model.getLocal(), is(anaisDeCongresso.getLocal()));
		assertThat(model.getNomeCongresso(), is(anaisDeCongresso.getNomeCongresso()));
		assertThat(model.getId(), is(anaisDeCongresso.getId()));
	}

	@Test
	public void deleteServiceTest() {
		AnaisDeCongresso anaisDeCongresso = new AnaisDeCongresso(1L, "Congresso A", "Campina Grande");
		when(anaisDeCongressoRepository.getOne(1L)).thenReturn(anaisDeCongresso);
		anaisDeCongressoRepository.deleteById(1L);
		verify(anaisDeCongressoRepository, times(1)).deleteById(1L);
		verifyNoMoreInteractions(anaisDeCongressoRepository);
	}

	@Test
	public void findAllServiceTest() {
		List<AnaisDeCongresso> models = new ArrayList<>();
		when(anaisDeCongressoRepository.findAll()).thenReturn(models);
		List<AnaisDeCongresso> actual = anaisDeCongressoService.findAll();
		verify(anaisDeCongressoRepository, times(1)).findAll();
		verifyNoMoreInteractions(anaisDeCongressoRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		AnaisDeCongresso anaisDeCongresso = new AnaisDeCongresso(1L, "Congresso A", "Campina Grande");
		when(anaisDeCongressoRepository.getOne(1L)).thenReturn(anaisDeCongresso);
		AnaisDeCongresso actual = anaisDeCongressoRepository.getOne(1L);
		verify(anaisDeCongressoRepository, times(1)).getOne(1L);
		verifyNoMoreInteractions(anaisDeCongressoRepository);
		assertThat(actual, is(anaisDeCongresso));
	}
}
