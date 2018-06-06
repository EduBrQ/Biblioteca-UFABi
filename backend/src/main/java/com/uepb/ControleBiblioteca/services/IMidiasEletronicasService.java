package com.uepb.ControleBiblioteca.services;

import java.util.List;

import com.uepb.ControleBiblioteca.entities.MidiasEletronicas;
import com.uepb.ControleBiblioteca.exception.MidiasEletronicasException;

public interface IMidiasEletronicasService {
	
	List<MidiasEletronicas> findAll();
	MidiasEletronicas findOne(Integer id);
	MidiasEletronicas create(MidiasEletronicas midiasEletronicas);
	MidiasEletronicas update(MidiasEletronicas midiasEletronicas, Integer Id);
	public void remove(Integer id);
    public MidiasEletronicas findById(Integer id) throws MidiasEletronicasException;

}
