package com.IdeaMode.todo_app.controller;

import com.IdeaMode.todo_app.model.Todo;
import com.IdeaMode.todo_app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Use RestController to return JSON responses
@RequestMapping("/todos")
@CrossOrigin
public class TodoController {

    // This will allow the controller to communicate with the service layer.

    @Autowired
    private TodoService todoService;

    // CRUD operation methods will go here.

    // Get all todo (GET request)
    @GetMapping
    public List<Todo> getTodos(){
        return todoService.getAllTodos();  // Returns a list of todos in JSON format
    }

    // Create a new todo (POST request) .. RequestBody is necessary to accept/add the data in JSON
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo); // Returns the created todo object in JSON
    }

    // Get a single todo by ID (GET request)
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id);  // Returns the todo object in JSON
    }

    // Update a todo by ID (PUT request)
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id);  // Set the ID to make sure we're updating the correct todo
        return todoService.saveTodo(todo);  // Returns the updated todo object in JSON
    }

    // Delete a todo by ID (DELETE request)
    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);  // Deletes the todo
    }




}
