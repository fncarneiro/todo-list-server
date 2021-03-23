package com.todolist.restapiserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.todolist.restapiserver.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {		
			
	  @Query("select t "
				+ "from Task t "
				+ "inner join fetch t.category c "						
				+ "order by t.id"
			)	
	  List<Task> findAllTasks();	 
}
