package com.Todo.backend.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @AfterEach
    void clean(){
        todoRepository.deleteAll();
    }

    @Test
    @DisplayName("작성")
    void insert(){
        TodoInsert todoInsert = TodoInsert.builder()
                .item("아이템")
                .date("date")
                .completed(true)
                .time("time")
                .build();

        //when
        todoService.insert(todoInsert);

        //then
        Assertions.assertEquals(1,todoRepository.count());
        Assertions.assertEquals("아이템",todoInsert.getItem());
        Assertions.assertTrue(todoInsert.isCompleted());



    }


}