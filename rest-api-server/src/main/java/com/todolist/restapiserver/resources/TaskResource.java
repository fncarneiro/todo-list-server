package com.todolist.restapiserver.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.restapiserver.models.Task;
import com.todolist.restapiserver.repository.TaskRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="ToDo List REST API")
public class TaskResource {
	@Autowired
	TaskRepository taskRepository;
	
	@ApiOperation(value="Return a list tasks.")
	@GetMapping("/tasks")
	public List<Task> findAllTasks(){
		return taskRepository.findAllTasks();
	}
	
	@ApiOperation(value="Return one task.")
	@GetMapping("/task/{id}")
	public Optional<Task> findTaskById(@PathVariable(value="id") Long id){
		return taskRepository.findById(id);
	}
	
	@ApiOperation(value="Insert new task.")
	@PostMapping("/task")
	public Task saveTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}	
	
	@ApiOperation(value="Delete one task.")
	@DeleteMapping("/task")
	public void deleteTask(@RequestBody Task task) {
		taskRepository.delete(task);
	}
	
	@ApiOperation(value="Update one task.")
	@PutMapping("/task")
	public Task updateTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}
}
