package com.todolist.restapiserver.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_TASK")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name = "ID_TASK", nullable = false)
    private long id;	
	
	@Column(name = "NM_TITLE", nullable = true)
    private String title;
	
	@Column(name = "NM_TASK", nullable = true)	
	private String task;	
	
	@ManyToOne(targetEntity=Category.class, fetch=FetchType.EAGER)
    @JoinColumn(name="ID_CATEGORY")
    private Category category;	

	public long getId() {
		return id;	
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}		
}
