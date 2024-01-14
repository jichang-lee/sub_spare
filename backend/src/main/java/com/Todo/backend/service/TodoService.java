package com.Todo.backend.service;

import com.Todo.backend.domain.Todo;
import com.Todo.backend.repository.TodoRepository;
import com.Todo.backend.request.todo.TodoInsert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void insert(TodoInsert todoInsert){

        Todo todo = Todo.builder()
                .item(todoInsert.getItem())
                .date(todoInsert.getDate())
                .completed(todoInsert.isCompleted())
                .time(todoInsert.getTime())
                .build();
        todoRepository.save(todo);

    }


}
