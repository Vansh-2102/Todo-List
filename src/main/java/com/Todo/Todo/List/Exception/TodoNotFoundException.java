package com.Todo.Todo.List.Exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String message) {

        super(message);
    }
}
