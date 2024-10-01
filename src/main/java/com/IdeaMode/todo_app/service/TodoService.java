package com.IdeaMode.todo_app.service;

import com.IdeaMode.todo_app.model.Todo;
import com.IdeaMode.todo_app.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    //This allows the service to interact with the database.
    @Autowired
    private TodoRepo todoRepo;

    // Business logic methods will go here.

    // To Get all todos
    public List<Todo> getAllTodos(){
        return todoRepo.findAll();
    }

    // Save or update a todo
    public Todo saveTodo(Todo todo){
        return todoRepo.save(todo);
    }

    // Get a single todo by ID
    public Todo getTodoById(Long id) {
        return todoRepo.findById(id).orElse(null);
    }

    // Delete a todo by ID
    public void deleteTodoById(Long id) {
        todoRepo.deleteById(id);
    }





}
