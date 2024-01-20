package com.Todo.backend.request.user;

import lombok.Builder;
import lombok.Data;

@Data
public class Login {

    private String email;
    private String password;

}
