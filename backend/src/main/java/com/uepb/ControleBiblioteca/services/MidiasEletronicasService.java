package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.MidiasEletronicasController;
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
	public MidiasEletronicas findOne(Integer id) {
		Optional<MidiasEletronicas> todoResult = midiasEletronicasRepository.findById(id);
		return todoResult.orElseThrow(() -> new MidiasEletronicasException("Error"));
	}

	@Override
	public void remove(Integer id) {
		if (this.midiasEletronicasRepository.existsById(id)) {
			this.midiasEletronicasRepository.deleteById(id);
		}
	}

	@Transactional(readOnly = true, rollbackFor = { MidiasEletronicasException.class })
	@Override
	public MidiasEletronicas findById(Integer id) throws MidiasEletronicasException {
		LOG.debug("Finding a to-do entry with id: {}", id);

		MidiasEletronicas found = midiasEletronicasRepository.findOne(id);
		LOG.debug("Found to-do entry: {}", found);

		if (found == null) {
			throw new MidiasEletronicasException("No to-entry found with id: " + id);
		}

		return found;
	}

	@Override
	public MidiasEletronicas update(MidiasEletronicas midiasEletronicasDetails, Integer Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		MidiasEletronicas midiasEletronicas = midiasEletronicasRepository.findById(Id).orElseThrow(() -> new MidiasEletronicasException("Error"));
		

		midiasEletronicas.setDataDeGravacao(midiasEletronicas.getDataDeGravacao());
		midiasEletronicas.setTipoMidia(midiasEletronicas.getTipoMidia());
		midiasEletronicas.setTitulo(midiasEletronicas.getTitulo());
		
		MidiasEletronicas updatedMidiasEletronicas = midiasEletronicasRepository.save(midiasEletronicas);

		return updatedMidiasEletronicas;
	}
}
