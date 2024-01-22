package com.Todo.backend.controller;

import com.Todo.backend.request.user.SignUp;
import com.Todo.backend.request.user.UserEdit;
import com.Todo.backend.response.user.UserResponse;
import com.Todo.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signUp(@RequestBody SignUp signUp){
        userService.Signup(signUp);
    }

    @PatchMapping("/update/{userId}")
    public void userEdit(@RequestBody UserEdit userEdit , @PathVariable Long userId){
        userService.editUser(userId,userEdit);
    }

}
