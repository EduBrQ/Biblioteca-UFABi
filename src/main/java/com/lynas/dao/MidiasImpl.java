package com.lynas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lynas.model.MidiasEletronicas;

@Repository
public class MidiasImpl implements MidiasEletronicasDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addMidiasEletronicas(MidiasEletronicas midiasEletronicas) {
		sessionFactory.getCurrentSession().saveOrUpdate(midiasEletronicas);

	}

	@SuppressWarnings("unchecked")
	public List<MidiasEletronicas> getAllMidiasEletronicass() {

		return sessionFactory.getCurrentSession().createQuery("from MidiasEletronicas")
				.list();
	}

	@Override
	public void deleteMidiasEletronicas(Integer midiasEletronicasId) {
		MidiasEletronicas midiasEletronicas = (MidiasEletronicas) sessionFactory.getCurrentSession().load(
				MidiasEletronicas.class, midiasEletronicasId);
		if (null != midiasEletronicas) {
			this.sessionFactory.getCurrentSession().delete(midiasEletronicas);
		}

	}

	public MidiasEletronicas getMidiasEletronicas(int empid) {
		return (MidiasEletronicas) sessionFactory.getCurrentSession().get(
				MidiasEletronicas.class, empid);
	}

	@Override
	public MidiasEletronicas updateMidiasEletronicas(MidiasEletronicas midiasEletronicas) {
		sessionFactory.getCurrentSession().update(midiasEletronicas);
		return midiasEletronicas;
	}

}