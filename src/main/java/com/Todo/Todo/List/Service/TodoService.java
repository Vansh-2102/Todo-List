package com.Todo.Todo.List.Service;


import com.Todo.Todo.List.Entity.Todo;
import com.Todo.Todo.List.Exception.TodoNotFoundException;
import com.Todo.Todo.List.Repository.TodoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRespository todoRespository;

    //get all todo
    public List<Todo> getAllTodo(){
        return todoRespository.findAll();
    }

    //get todo by id
    public Todo getTodoById(Long id){
        return todoRespository.findById(id)
                .orElseThrow(()-> new TodoNotFoundException("Todo with id " + id + " not found"));
    }


    //create todo
    public Todo createTodo(Todo todo){
        return todoRespository.save(todo);
    }

    //delete todo
    public void deleteTodo(Long id){
        todoRespository.deleteById(id);
    }

    //update Todo by id
    public Todo updateTodo(Long id, Todo todo) {
        Todo existing = todoRespository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo with id " + id + " not found"));
        existing.setTitle(todo.getTitle());
        existing.setCompleted(todo.isCompleted());
        return todoRespository.save(existing);
    }

}
