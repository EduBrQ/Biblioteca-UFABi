package com.uepb.ControleBiblioteca.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uepb.ControleBiblioteca.entities.Task;
import com.uepb.ControleBiblioteca.exception.TaskException;
import com.uepb.ControleBiblioteca.repository.TaskRepository;
import com.uepb.ControleBiblioteca.services.ITaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tasks")
@Api(value = "API Rest - Task Endpoint")
public class TaskController {

	private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private ITaskService taskService;

	public TaskController(ITaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	@ApiOperation(value = "Busca todos os dados do banco.")
	public List<Task> findAll() {
		LOG.warn("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.taskService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um dado do banco através do id.")
	public Optional<Task> findOne(@PathVariable("id") Long id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.taskService.findOne(id);
	}

	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Cria um dado no banco.")
	public Task create(@RequestBody Task task) {
		LOG.error("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.taskService.create(task);
	}

	// Update a Task
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita um dado do Banco através id.")
	public Task update(@PathVariable(value = "id") Long Id, @RequestBody Task taskDetails) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		return this.taskService.update(taskDetails, Id);
	}
	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um dado do Banco através id.")
	public void remove(@PathVariable("id") Long id) {
		LOG.info("THIAGO PABLICIO CABRAL DA SILVA...");
		this.taskService.remove(id);
	}

}
