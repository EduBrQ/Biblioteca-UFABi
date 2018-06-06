package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.CursoController;
import com.uepb.ControleBiblioteca.entities.Curso;
import com.uepb.ControleBiblioteca.exception.CursoException;
import com.uepb.ControleBiblioteca.repository.CursoRepository;

@Service
public class CursoService implements ICursoService {

	private static final Logger LOG = LoggerFactory.getLogger(CursoController.class);

	@Autowired
	private CursoRepository cursoRepository;

	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@Override
	public List<Curso> findAll() {
		return this.cursoRepository.findAll();
	}

	@Override
	public Curso create(Curso curso) {
		return this.cursoRepository.save(curso);
	}

	@Override
	public Curso findOne(Integer id) {
		Optional<Curso> todoResult = cursoRepository.findById(id);
		return todoResult.orElseThrow(() -> new CursoException("Error"));
	}

	@Override
	public void remove(Integer id) {
		if (this.cursoRepository.existsById(id)) {
			this.cursoRepository.deleteById(id);
		}
	}

	@Transactional(readOnly = true, rollbackFor = { CursoException.class })
	@Override
	public Curso findById(Integer id) throws CursoException {
		LOG.debug("Finding a to-do entry with id: {}", id);

		Curso found = cursoRepository.findOne(id);
		LOG.debug("Found to-do entry: {}", found);

		if (found == null) {
			throw new CursoException("No to-entry found with id: " + id);
		}

		return found;
	}

	@Override
	public Curso update(Curso cursoDetails, Integer Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		Curso curso = cursoRepository.findById(Id).orElseThrow(() -> new CursoException("Error"));

		curso.setNome(cursoDetails.getNome());

		curso.setArea(cursoDetails.getArea());

		curso.setTipo(cursoDetails.getTipo());

		Curso updatedCurso = cursoRepository.save(curso);

		return updatedCurso;
	}
}
