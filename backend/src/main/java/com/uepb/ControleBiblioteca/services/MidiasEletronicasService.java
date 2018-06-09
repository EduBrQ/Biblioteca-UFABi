package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.MidiasEletronicasController;
import com.uepb.ControleBiblioteca.entities.Aluno;
import com.uepb.ControleBiblioteca.entities.MidiasEletronicas;
import com.uepb.ControleBiblioteca.exception.MidiasEletronicasException;
import com.uepb.ControleBiblioteca.repository.MidiasEletronicasRepository;

@Service
public class MidiasEletronicasService implements IMidiasEletronicasService {

	private static final Logger LOG = LoggerFactory.getLogger(MidiasEletronicasController.class);

	@Autowired
	private MidiasEletronicasRepository midiasEletronicasRepository;

	public MidiasEletronicasService(MidiasEletronicasRepository midiasEletronicasRepository) {
		this.midiasEletronicasRepository = midiasEletronicasRepository;
	}

	@Override
	public List<MidiasEletronicas> findAll() {
		return this.midiasEletronicasRepository.findAll();
	}

	@Override
	public MidiasEletronicas create(MidiasEletronicas midiasEletronicas) {
		return this.midiasEletronicasRepository.save(midiasEletronicas);
	}
	
	@Override
	public Optional<MidiasEletronicas> findOne(Long id) {
		return this.midiasEletronicasRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		if (this.midiasEletronicasRepository.existsById(id)) {
			this.midiasEletronicasRepository.deleteById(id);
		}
	}

	
	@Override
	public MidiasEletronicas update(MidiasEletronicas midiasEletronicasDetails, Long Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		MidiasEletronicas midiasEletronicas = midiasEletronicasRepository.findById(Id).orElseThrow(() -> new MidiasEletronicasException("Error"));
		

		midiasEletronicas.setDataDeGravacao(midiasEletronicas.getDataDeGravacao());
		midiasEletronicas.setTipoMidia(midiasEletronicas.getTipoMidia());
		midiasEletronicas.setTitulo(midiasEletronicas.getTitulo());
		
		MidiasEletronicas updatedMidiasEletronicas = midiasEletronicasRepository.save(midiasEletronicas);

		return updatedMidiasEletronicas;
	}
}
