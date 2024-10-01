package com.IdeaMode.todo_app.repository;

import com.IdeaMode.todo_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
}
