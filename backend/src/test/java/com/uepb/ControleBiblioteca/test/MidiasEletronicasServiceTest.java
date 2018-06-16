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

import com.uepb.ControleBiblioteca.entities.MidiasEletronicas;
import com.uepb.ControleBiblioteca.repository.MidiasEletronicasRepository;
import com.uepb.ControleBiblioteca.services.MidiasEletronicasService;

@RunWith(SpringRunner.class)
public class MidiasEletronicasServiceTest {

	@Mock
	private MidiasEletronicasService midiasEletronicasService;

	@Mock
	private MidiasEletronicasRepository midiasEletronicasRepository;

	@Before
	public void setUp() {
		midiasEletronicasRepository = mock(MidiasEletronicasRepository.class);
		midiasEletronicasService = new MidiasEletronicasService(midiasEletronicasRepository);
	}

	@Test
	public void addNewMidiasEletronicasServiceTest() {
		MidiasEletronicas midiasEletronicas = new MidiasEletronicas(1L, "calypso", "cd");
		midiasEletronicasService.create(midiasEletronicas);
		ArgumentCaptor<MidiasEletronicas> midiasEletronicasArgument = ArgumentCaptor.forClass(MidiasEletronicas.class);
		verify(midiasEletronicasRepository, times(1)).save(midiasEletronicasArgument.capture());
		verifyNoMoreInteractions(midiasEletronicasRepository);
		MidiasEletronicas model = midiasEletronicasArgument.getValue();
		assertThat(model.getTitulo(), is(midiasEletronicas.getTitulo()));
		assertThat(model.getTipoMidia(), is(midiasEletronicas.getTipoMidia()));
		assertThat(model.getId(), is(midiasEletronicas.getId()));
	}

	@Test
	public void deleteServiceTest() {
		MidiasEletronicas midiasEletronicas = new MidiasEletronicas(1L, "calypso", "cd");
		when(midiasEletronicasRepository.getOne(1L)).thenReturn(midiasEletronicas);
		midiasEletronicasRepository.deleteById(1L);
		verify(midiasEletronicasRepository, times(1)).deleteById(1L);
		verifyNoMoreInteractions(midiasEletronicasRepository);
	}

	@Test
	public void findAllServiceTest() {
		List<MidiasEletronicas> models = new ArrayList<>();
		when(midiasEletronicasRepository.findAll()).thenReturn(models);
		List<MidiasEletronicas> actual = midiasEletronicasService.findAll();
		verify(midiasEletronicasRepository, times(1)).findAll();
		verifyNoMoreInteractions(midiasEletronicasRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		MidiasEletronicas midiasEletronicas = new MidiasEletronicas(1L, "calypso", "cd");
		when(midiasEletronicasRepository.getOne(1L)).thenReturn(midiasEletronicas);
		MidiasEletronicas actual = midiasEletronicasRepository.getOne(1L);
		verify(midiasEletronicasRepository, times(1)).getOne(1L);
		verifyNoMoreInteractions(midiasEletronicasRepository);
		assertThat(actual, is(midiasEletronicas));
	}
}
