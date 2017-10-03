package com.todo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="todo")
public class ToDoList {

    @Id
    private String id;

    private String name;

    private String status;
    
    public ToDoList(){
    	
    }
	public ToDoList(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
