package com.Todo.backend.response.user;

import com.Todo.backend.domain.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {

    private Long id;
    private String email;
    private String username;


    public UserResponse(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }

    @Builder
    public UserResponse(Long id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }
}
