package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.Task;

public interface ITaskService {

	List<Task> findAll();
	Optional<Task> findOne(Long id);
	Task create(Task task);
}
