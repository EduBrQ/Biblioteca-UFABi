package com.uepb.controlebiblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.controlebiblioteca.dao.MidiasEletronicasDao;
import com.uepb.controlebiblioteca.model.MidiasEletronicas;
import com.uepb.controlebiblioteca.service.MidiasEletronicasService;

@Service
@Transactional
public class MidiasEletronicasServiceImpl implements MidiasEletronicasService {

	@Autowired
	private MidiasEletronicasDao MidiasEletronicasDao;

	@Override
	@Transactional
	public void addMidiasEletronicas(MidiasEletronicas midiasEletronicas) {
		MidiasEletronicasDao.addMidiasEletronicas(midiasEletronicas);
	}

	@Override
	@Transactional
	public List<MidiasEletronicas> getAllMidiasEletronicass() {
		return MidiasEletronicasDao.getAllMidiasEletronicass();
	}

	@Override
	@Transactional
	public void deleteMidiasEletronicas(Integer midiasEletronicasId) {
		MidiasEletronicasDao.deleteMidiasEletronicas(midiasEletronicasId);
	}

	public MidiasEletronicas getMidiasEletronicas(int empid) {
		return MidiasEletronicasDao.getMidiasEletronicas(empid);
	}

	public MidiasEletronicas updateMidiasEletronicas(MidiasEletronicas midiasEletronicas) {
		// TODO Auto-generated method stub
		return MidiasEletronicasDao.updateMidiasEletronicas(midiasEletronicas);
	}

	public void setMidiasEletronicasDao(MidiasEletronicasDao midiasEletronicasDao) {
		this.MidiasEletronicasDao = midiasEletronicasDao;
	}

}
