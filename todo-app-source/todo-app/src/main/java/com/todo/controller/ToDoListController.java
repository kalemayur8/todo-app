package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.ToDoList;
import com.todo.info.TodoInfo;
import com.todo.service.TodoListService;

@RestController
@RequestMapping("/list")
public class ToDoListController {
	 	@Autowired
	    private TodoListService todoListService;

	    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	    public List<ToDoList> getToDoList() {
	        return todoListService.findAll();
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value ="/pending")
	    public List<ToDoList> getToDoPendingList() {
	        return todoListService.findPendingList();
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value ="/complete")
	    public List<ToDoList> getToDoCompleteList() {
	        return todoListService.findCompleteList();
	    }
	    
	    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json", value ="/complete")
	    public List<ToDoList> completedList(@RequestBody TodoInfo  todoList) {
	        return todoListService.updateProduct(todoList);
	    }
	    
	    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
	    public List<ToDoList> deleteItem(@PathVariable("id") String ids) {
	    	return todoListService.delete(ids);
	    }
	    
	    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	    public List<ToDoList> addItem(@RequestBody TodoInfo  todoList) {
	        return todoListService.save(todoList);
	    }
}
