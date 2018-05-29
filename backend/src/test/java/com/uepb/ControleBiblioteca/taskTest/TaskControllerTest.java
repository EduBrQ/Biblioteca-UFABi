package com.uepb.ControleBiblioteca.taskTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.uepb.ControleBiblioteca.controller.TaskController;
import com.uepb.ControleBiblioteca.entities.Task;
import com.uepb.ControleBiblioteca.repository.TaskRepository;
import com.uepb.ControleBiblioteca.services.TaskService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private TaskService taskService;
	
	@MockBean
	private TaskRepository taskRepository;

	@Test
	public void findAllTest() throws Exception {
		Task task1 = new Task((long) 1, "Leonan", true);
		List<Task> mockPeople = Arrays.asList(task1);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockTaskJSON = ow.writeValueAsString(mockPeople);
		when(taskService.findAll()).thenReturn(mockPeople);
		mock.perform(get("/tasks").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().is(200))
				.andExpect(content().json(mockTaskJSON));
	}

	@Test
	public void findOneTest() throws Exception {
		Task task1 = new Task();
		mock.perform(get("/tasks" + "/{id}", task1.getId()).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}

	@Test
	public void createNewTaskTest() throws Exception {
		Task mockTask = new Task((long) 10, "Erik", false);
		when(taskService.create(any(Task.class))).thenReturn(mockTask);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockTaskJSON = ow.writeValueAsString(mockTask);
		mock.perform(post("/tasks").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.content(mockTaskJSON)).andExpect(status().isOk()).andExpect(content().json(mockTaskJSON));
		verify(taskService).create(any(Task.class));
	}

	@Test
	public void removeTask() throws Exception {
		mock.perform(delete("/tasks" + "/{id}", new Long(1))).andExpect(status().is(200));
	}

	@Test
	public void createNewTaskAndFailTest() throws Exception {
		Task mockTask = new Task((long) 1, "56", true);
		when(taskService.create(any(Task.class))).thenReturn(mockTask);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(mockTask);
		mock.perform(post("/tasks").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.content(json)).andExpect(status().is(200));
	}

	@Test
	public void editNewTaskTest() throws Exception {	
		Task mockTask = new Task((long) 10, "Erik", false);
		when(taskService.update(taskService.findById(1L), 1L)).thenReturn(mockTask);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockTaskJSON = ow.writeValueAsString(mockTask);
		mock.perform(put("/tasks/1").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
						.content(mockTaskJSON))
				.andExpect(status().isOk());
	
	}
}
