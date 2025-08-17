package com.Todo.Todo.List.Repository;

import com.Todo.Todo.List.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRespository extends JpaRepository<Todo , Long> {
}
