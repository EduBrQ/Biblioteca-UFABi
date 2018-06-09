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
import com.uepb.ControleBiblioteca.entities.Task;
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
	public Optional<Curso> findOne(Long id) {
		return this.cursoRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		if (this.cursoRepository.existsById(id)) {
			this.cursoRepository.deleteById(id);
		}
	}

	

	@Override
	public Curso update(Curso cursoDetails, Long Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		Curso curso = cursoRepository.findById(Id).orElseThrow(() -> new CursoException("Error"));
		
		curso.setNome(cursoDetails.getNome());
		curso.setArea(cursoDetails.getArea());
		curso.setTipo(cursoDetails.getTipo());

		Curso updatedCurso = cursoRepository.save(curso);

		return updatedCurso;
	}
}
