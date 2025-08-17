package com.Todo.Todo.List.Controller;

import com.Todo.Todo.List.Entity.Todo;
import com.Todo.Todo.List.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    //get all todo
    @GetMapping
    public List<Todo> getAllTodo(){
        return todoService.getAllTodo();
    }

    //get todo by id
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id);
    }

    //create todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }


    //delete todo
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id){
         todoService.deleteTodo(id);
         return "todo Id:" + id + " is deleted";
    }

    //update todo by id
    @PutMapping("/{id}")
    public Todo updateTodoById(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.updateTodo(id, todo);
    }

}
