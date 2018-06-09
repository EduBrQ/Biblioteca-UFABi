package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.MidiasEletronicas;
import com.uepb.ControleBiblioteca.exception.MidiasEletronicasException;

public interface IMidiasEletronicasService {

	List<MidiasEletronicas> findAll();
	Optional<MidiasEletronicas> findOne(Long id);
	MidiasEletronicas create(MidiasEletronicas midiasEletronicas);
	MidiasEletronicas update(MidiasEletronicas midiasEletronicas, Long Id);
	public void remove(Long id);
//    public MidiasEletronicas findById(Long id) throws MidiasEletronicasException;

}
