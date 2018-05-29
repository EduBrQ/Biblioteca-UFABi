package com.uepb.ControleBiblioteca.taskTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.springframework.test.context.junit4.SpringRunner;

import com.uepb.ControleBiblioteca.entities.Task;
import com.uepb.ControleBiblioteca.repository.TaskRepository;
import com.uepb.ControleBiblioteca.services.TaskService;

@RunWith(SpringRunner.class)
public class TaskServiceTest {

	@Mock
	private TaskService taskService;
	
	@Mock
	private TaskRepository taskRepository;

	@Test
	public void addNewTaskServiceTest() {
		Task task1 = new Task();
		task1.setId(1L);
		task1.setName("claudio");
		task1.setDone(true);
		taskService.create(task1);		
		when(taskService.findById(1L)).thenReturn(task1);
		Task actual = taskService.findById(1L);		
		assertThat(actual, is(task1));
	}
	
	@Test
	public void deleteServiceTest() {
		Task task1 = new Task();
		task1.setId(1L);
		task1.setName("claudio");
		task1.setDone(true);
		taskService.create(task1);
        when(taskRepository.findOne(task1.getId())).thenReturn(task1);
        taskService.remove(1L);      
        assertNull(taskService.findById(1L));       
	}

	
	@Test
	public void findAllServiceTest() {
		List<Task> models = new ArrayList<>();
		when(taskService.findAll()).thenReturn(models);
		List<Task> actual = taskService.findAll();
		verify(taskService, times(1)).findAll();
		verifyNoMoreInteractions(taskRepository);
		assertThat(actual, is(models));
	}

	@Test
	public void testFindByIdService() {
		Task task = new Task(1L, "OI", false);
		when(taskService.findById(1L)).thenReturn(task);
		Task actual = taskService.findById(1L);
		assertThat(actual, is(task));
	}
	
	@Test
	public void testUpdateService() {
		Task task = new Task(1L, "OI", false);
		when(taskService.findById(1L)).thenReturn(task);
		task.setName("Modf");
		this.taskRepository.save(task);
		task = this.taskService.findById(1L);
		assertEquals("Modf", task.getName());
	}

}
