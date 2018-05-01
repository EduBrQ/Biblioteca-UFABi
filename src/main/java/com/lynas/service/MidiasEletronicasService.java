package com.lynas.service;

import java.util.List;

import com.lynas.model.MidiasEletronicas;

public interface MidiasEletronicasService {
	
	public void addMidiasEletronicas(MidiasEletronicas midiasEletronicas);

	public List<MidiasEletronicas> getAllMidiasEletronicass();

	public void deleteMidiasEletronicas(Integer midiasEletronicasId);

	public MidiasEletronicas getMidiasEletronicas(int midiasEletronicasid);

	public MidiasEletronicas updateMidiasEletronicas(MidiasEletronicas midiasEletronicas);
}
