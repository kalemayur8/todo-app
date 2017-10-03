package com.todo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todo.entity.ToDoList;


public interface ToDoListRepository extends MongoRepository<ToDoList, String> {

}
