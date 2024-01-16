package com.Todo.backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    private String item;

    private String date;

    private boolean completed;

    private String time;

    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String useYn;

    @Builder
    public Todo( String item, String date, boolean completed, String time) {
        this.item = item;
        this.date = date;
        this.completed = completed;
        this.time = time;
        this.writeDate = LocalDateTime.now();
        this.updateDate = updateDate;
    }
}
