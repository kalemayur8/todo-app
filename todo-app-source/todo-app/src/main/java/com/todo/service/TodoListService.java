package com.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.entity.ToDoList;
import com.todo.info.TodoInfo;
import com.todo.repo.ToDoListRepository;

@Service
@Transactional
public class TodoListService {
	
	    @Autowired
	    private ToDoListRepository todoListRepository;

	    private static List<ToDoList> todos = new ArrayList<>();

	    static {
	    	todos.add(new ToDoList("Buy food","PENDING"));
	    	todos.add(new ToDoList("Online Payment","COMPLETE"));
	    	todos.add(new ToDoList("Fetch Books","PENDING"));
	    	todos.add(new ToDoList("Coding","PENDING"));
	    	todos.add(new ToDoList("Ticket Book","PENDING"));
	    	todos.add(new ToDoList("Meeting","PENDING"));
	    }
	    public void saveInitialBatch(){
	        todoListRepository.save(todos);
	    }
	    
	    public List<ToDoList> findPendingList(){
	        return todoListRepository.findAll()
	        		.stream()
	        		.filter(todo -> !todo.getStatus().equals("COMPLETE"))
	        		.collect(Collectors.toList());
	    }

	    public List<ToDoList> findAll(){
	        return todoListRepository.findAll();
	    }

		public List<ToDoList> updateProduct(TodoInfo todoList) {
			ToDoList todo = todoListRepository.findOne(todoList.getId());
			todo.setStatus("COMPLETE");
			todoListRepository.save(todo);
			return findAll();
		}

		public List<ToDoList> delete(String id) {
			todoListRepository.delete(id);
			return findAll();
		}

		public List<ToDoList> save(TodoInfo todoList) {
			todoListRepository.save(TodoInfo.toTodoList(todoList));
			return findAll();
		}

		public List<ToDoList> findCompleteList() {
			return todoListRepository.findAll()
	        		.stream()
	        		.filter(todo -> !todo.getStatus().equals("PENDING"))
	        		.collect(Collectors.toList());
		}
}
