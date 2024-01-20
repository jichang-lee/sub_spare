package com.Todo.backend.controller;

import com.Todo.backend.request.user.SignUp;
import com.Todo.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public void signUp(@RequestBody SignUp signUp){
        userService.Signup(signUp);
    }

}