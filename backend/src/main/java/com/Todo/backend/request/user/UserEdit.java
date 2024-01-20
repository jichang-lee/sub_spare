package com.Todo.backend.request.user;

import lombok.Builder;
import lombok.Data;

@Data
public class UserEdit {

    private String email;
    private String password;
    private String username;

    @Builder
    public UserEdit(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
