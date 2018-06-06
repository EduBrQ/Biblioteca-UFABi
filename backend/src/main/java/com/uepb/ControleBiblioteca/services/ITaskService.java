package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import com.uepb.ControleBiblioteca.entities.Task;
import com.uepb.ControleBiblioteca.exception.TaskException;

public interface ITaskService {

	List<Task> findAll();
	Optional<Task> findOne(Long id);
	Task create(Task task);
	Task update(Task task, Long Id);
	public void remove(Long id);
//    public Task findById(Long id) throws TaskException;

}
