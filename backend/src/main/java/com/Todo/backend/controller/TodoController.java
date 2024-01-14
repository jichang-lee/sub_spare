package com.Todo.backend.controller;

import com.Todo.backend.request.todo.TodoInsert;
import com.Todo.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todo/write")
    public void todoInsert(@RequestBody TodoInsert todoInsert){
        todoService.insert(todoInsert);
    }
}
