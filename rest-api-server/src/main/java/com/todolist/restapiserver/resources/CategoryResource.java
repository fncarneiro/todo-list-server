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

import com.todolist.restapiserver.models.Category;
import com.todolist.restapiserver.repository.CategoryRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="ToDo List REST API")
public class CategoryResource {	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@ApiOperation(value="Return list categories order by name.")	  
	@GetMapping("/categories") 
	public List<Category> listCategories(){ 
		return categoryRepository.findAll();
	}	 
	
	@ApiOperation(value="Return one category.")
	@GetMapping("/category/{id}")
	public Optional<Category> findById(@PathVariable(value="id") Long id){
		return categoryRepository.findById(id);
	}	
	
	@ApiOperation(value="Insert new category.")
	@PostMapping("/category")
	public Category saveCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	@ApiOperation(value="Delete one category.")
	@DeleteMapping("/category")
	public void deleteCategory(@RequestBody Category category) {
		categoryRepository.delete(category);
	}
	
	@ApiOperation(value="Update one category.")
	@PutMapping("/category")
	public Category updateCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
}
