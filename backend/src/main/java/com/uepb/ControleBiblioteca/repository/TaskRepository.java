package com.uepb.ControleBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.ControleBiblioteca.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	
	
}
