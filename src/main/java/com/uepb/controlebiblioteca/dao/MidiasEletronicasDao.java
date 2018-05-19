package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.MidiasEletronicas;

/**
 * Interface que define os metodos que podem ser utilizados implementando a mesma.
 * @author Eduardo Borba
 *
 */
public interface MidiasEletronicasDao {

	public void addMidiasEletronicas(MidiasEletronicas midiasEletronicas);

	public List<MidiasEletronicas> getAllMidiasEletronicass();

	public void deleteMidiasEletronicas(Integer midiasEletronicasId);

	public MidiasEletronicas updateMidiasEletronicas(MidiasEletronicas midiasEletronicas);

	public MidiasEletronicas getMidiasEletronicas(int midiasEletronicasid);
}
