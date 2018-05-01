package com.lynas.service;

import java.util.List;

import com.lynas.model.Rdm;

public interface RdmService {
	
	public void addRdm(Rdm rdm);

	public List<Rdm> getAllRdms();

	public void deleteRdm(Integer rdmId);

	public Rdm getRdm(int rdmid);

	public Rdm updateRdm(Rdm rdm);
}
