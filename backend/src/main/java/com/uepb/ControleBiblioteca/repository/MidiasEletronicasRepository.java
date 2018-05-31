package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.MidiasEletronicas;

@Repository
public interface MidiasEletronicasRepository extends JpaRepository<MidiasEletronicas, Integer> {

	MidiasEletronicas findOne(int id);
	MidiasEletronicas update(MidiasEletronicas midiasEletronicas, int id);
	
}
