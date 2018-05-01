package com.lynas.dao;

import java.util.List;
import com.lynas.model.MidiasEletronicas;

public interface MidiasEletronicasDao {

	public void addMidiasEletronicas(MidiasEletronicas midiasEletronicas);

	public List<MidiasEletronicas> getAllMidiasEletronicass();

	public void deleteMidiasEletronicas(Integer midiasEletronicasId);

	public MidiasEletronicas updateMidiasEletronicas(MidiasEletronicas midiasEletronicas);

	public MidiasEletronicas getMidiasEletronicas(int midiasEletronicasid);
}
