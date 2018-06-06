package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.AlunoController;
import com.uepb.ControleBiblioteca.entities.Aluno;
import com.uepb.ControleBiblioteca.entities.Task;
import com.uepb.ControleBiblioteca.exception.AlunoException;
import com.uepb.ControleBiblioteca.repository.AlunoRepository;

@Service
public class AlunoService implements IAlunoService {

	private static final Logger LOG = LoggerFactory.getLogger(AlunoController.class);

	@Autowired
	private AlunoRepository alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<Aluno> findAll() {
		return this.alunoRepository.findAll();
	}

	@Override
	public Aluno create(Aluno aluno) {
		return this.alunoRepository.save(aluno);
	}

	@Override
	public Optional<Aluno> findOne(Long id) {
		return this.alunoRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		if (this.alunoRepository.existsById(id)) {
			this.alunoRepository.deleteById(id);
		}
	}

	

	@Override
	public Aluno update(Aluno alunoDetails, Long Id) {

		LOG.debug("Finding a to-do entry with id: {}", Id);

		Aluno aluno = alunoRepository.findById(Id).orElseThrow(() -> new AlunoException("Error"));
		
		aluno.setCpf(alunoDetails.getCpf());
		
		aluno.setCurso(alunoDetails.getCurso());
		
		aluno.setEmail(alunoDetails.getEmail());
		
		aluno.setEndereco(alunoDetails.getEndereco());
		
		aluno.setMatricula(alunoDetails.getMatricula());
		
		aluno.setNaturalidade(alunoDetails.getNaturalidade());
		
		aluno.setNivel(alunoDetails.getNivel());
		
		aluno.setNomemae(alunoDetails.getNomemae());
		
		aluno.setPeriodo(alunoDetails.getPeriodo());
		
		aluno.setRg(alunoDetails.getRg());
		
		aluno.setTelefone(alunoDetails.getTelefone());
		
		aluno.setAno(alunoDetails.getAno());

		aluno.setCurso(alunoDetails.getCurso());

		aluno.setNome(alunoDetails.getNome());

		Aluno updatedAluno = alunoRepository.save(aluno);

		return updatedAluno;
	}
}
