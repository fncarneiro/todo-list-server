package com.todolist.restapiserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.restapiserver.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {	
	
}
