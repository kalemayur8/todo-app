package com.todo.info;

import com.todo.entity.ToDoList;

public class TodoInfo {
	private String id;

    private String name;

    private String status;

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

	public static ToDoList toTodoList(TodoInfo todoList) {
		ToDoList doList = new ToDoList();
		doList.setStatus("PENDING");
		doList.setName(todoList.getName());
		return doList;
	}
}
