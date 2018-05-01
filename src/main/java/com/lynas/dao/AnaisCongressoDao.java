package com.lynas.dao;

import java.util.List;
import com.lynas.model.AnaisCongresso;

public interface AnaisCongressoDao {

	public void addAnaisCongresso(AnaisCongresso anaisCongresso);

	public List<AnaisCongresso> getAllAnaisCongressos();

	public void deleteAnaisCongresso(Integer anaisCongressoId);

	public AnaisCongresso updateAnaisCongresso(AnaisCongresso anaisCongresso);

	public AnaisCongresso getAnaisCongresso(int anaisCongressoid);
}
