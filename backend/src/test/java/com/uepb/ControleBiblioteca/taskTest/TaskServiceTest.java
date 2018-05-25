package com.uepb.ControleBiblioteca.taskTest;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

	@Before
	public void setUp() {
		taskRepository = mock(TaskRepository.class);
		taskService = new TaskService(taskRepository);
	}

	@Test
	public void addNewTaskServiceTest() {
		Task task = new Task(1L, "OI", false);
		taskService.create(task);
		ArgumentCaptor<Task> taskArgument = ArgumentCaptor.forClass(Task.class);
		verify(taskRepository, times(1)).save(taskArgument.capture());
		verifyNoMoreInteractions(taskRepository);
		Task model = taskArgument.getValue();
		assertThat(model.getName(), is(task.getName()));
		assertThat(model.getId(), is(task.getId()));
	}
	
//
//	@Test
//	public void deleteServiceTest() {
//		Task task = new Task(1L, "OI", false);
//		when(taskRepository.findOne(1L)).thenReturn(task);
//
//		taskService.remove(1L);
//
//        verify(taskRepository, times(1)).findById(1L);
//        verify(taskRepository, times(2)).delete(task);
//        verifyNoMoreInteractions(taskRepository);
//
//	}

	@Test
	public void findAllServiceTest() {
		List<Task> models = new ArrayList<>();
		when(taskRepository.findAll()).thenReturn(models);
		List<Task> actual = taskService.findAll();
		verify(taskRepository, times(1)).findAll();
		verifyNoMoreInteractions(taskRepository);
		assertThat(actual, is(models));
	}


//	@Test
//	public void testFindByIdService() {
//		Task task = new Task(1L, "OI", false);
//		when(taskService.findById(1L)).thenReturn(task);
//		Task actual = taskService.findById(1L);
//		verify(taskRepository, times(1)).findById(1L);
//		verifyNoMoreInteractions(taskRepository);
//		assertThat(actual, is(task));
//	}


//	@Test
//	public void update_TodoEntryFound_ShouldUpdateTodoEntry() throws TodoNotFoundException {
//		TodoDTO dto = new TodoDTOBuilder().id(ID).description(DESCRIPTION_UPDATED).title(TITLE_UPDATED).build();
//
//		Todo model = new TodoBuilder().id(ID).description(DESCRIPTION).title(TITLE).build();
//
//		when(repositoryMock.findOne(dto.getId())).thenReturn(model);
//
//		Todo actual = service.update(dto);
//
//		verify(repositoryMock, times(1)).findOne(dto.getId());
//		verifyNoMoreInteractions(repositoryMock);
//
//		assertThat(model.getId(), is(dto.getId()));
//		assertThat(model.getDescription(), is(dto.getDescription()));
//		assertThat(model.getTitle(), is(dto.getTitle()));
//	}


}
