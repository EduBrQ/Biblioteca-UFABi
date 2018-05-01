package com.lynas.dao;

import java.util.List;
import com.lynas.model.Rdm;

public interface RdmDao {

	public void addRdm(Rdm rdm);

	public List<Rdm> getAllRdms();

	public void deleteRdm(Integer rdmId);

	public Rdm updateRdm(Rdm rdm);

	public Rdm getRdm(int rdmid);
}
