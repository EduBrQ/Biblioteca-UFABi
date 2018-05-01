package com.lynas.service;

import java.util.List;

import com.lynas.model.AnaisCongresso;

public interface AnaisCongressoService {
	
	public void addAnaisCongresso(AnaisCongresso anaisCongresso);

	public List<AnaisCongresso> getAllAnaisCongressos();

	public void deleteAnaisCongresso(Integer anaisCongressoId);

	public AnaisCongresso getAnaisCongresso(int anaisCongressoid);

	public AnaisCongresso updateAnaisCongresso(AnaisCongresso anaisCongresso);
}
