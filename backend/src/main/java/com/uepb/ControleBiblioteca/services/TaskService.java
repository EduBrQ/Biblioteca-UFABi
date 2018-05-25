package com.uepb.ControleBiblioteca.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uepb.ControleBiblioteca.controller.TaskController;
import com.uepb.ControleBiblioteca.entities.Task;
import com.uepb.ControleBiblioteca.exception.TaskException;
import com.uepb.ControleBiblioteca.repository.TaskRepository;


@Service
public class TaskService implements ITaskService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);


	@Autowired
	private TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@Override
	public List<Task> findAll() {
		return this.taskRepository.findAll();
	}
	

	@Override
	public Task create(Task task) {
		return this.taskRepository.save(task);
	}

	@Override
	public Task findOne(Long id) {
		  Optional<Task> todoResult = taskRepository.findById(id);
	        return todoResult.orElseThrow(() -> new TaskException("Error"));
	}
	
	
	@Override
	public void remove(Long id) {
		if (this.taskRepository.existsById(id)) {
			this.taskRepository.deleteById(id);
		}
	}
	
    @Transactional(readOnly = true, rollbackFor = {TaskException.class})
    @Override
    public Task findById(Long id) throws TaskException {
    	LOG.debug("Finding a to-do entry with id: {}", id);

        Task found = taskRepository.findOne(id);
        LOG.debug("Found to-do entry: {}", found);

        if (found == null) {
            throw new TaskException("No to-entry found with id: " + id);
        }

        return found;
    }
}
