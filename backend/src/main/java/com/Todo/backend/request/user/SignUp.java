package com.Todo.backend.request.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignUp {

    private String email;
    private String password;
    private String username;
    private LocalDateTime createAt;


    @Builder
    public SignUp(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.createAt = LocalDateTime.now();
    }
}
