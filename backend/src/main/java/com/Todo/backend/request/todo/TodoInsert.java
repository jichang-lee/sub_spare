package com.Todo.backend.request.todo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
public class TodoInsert {

    @NotEmpty(message = "내용은 필수입니다.")
    private String item;

    private String date;

    private boolean completed;

    private String time;

    @Builder
    public TodoInsert(String item, String date, boolean completed, String time) {
        this.item = item;
        this.date = date;
        this.completed = completed;
        this.time = time;
    }
}
