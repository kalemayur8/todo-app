package com.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.todo.service.TodoListService;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ToDoListApplication.class, args);
		
		TodoListService productService = applicationContext.getBean(TodoListService.class);
		productService.saveInitialBatch();

	}
}
