package com.Todo.backend.service;

import com.Todo.backend.domain.User;
import com.Todo.backend.exception.AlreadyExistsEmail;
import com.Todo.backend.repository.UserRepository;
import com.Todo.backend.request.user.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void Signup(SignUp singUp){

       Optional<User> byEmail = userRepository.findByEmail(singUp.getEmail());
       if(byEmail.isPresent()){
          throw new AlreadyExistsEmail();
       }
        String encode = passwordEncoder.encode(singUp.getPassword());
        User user = User.builder()
                .email(singUp.getEmail())
                .password(encode)
                .username(singUp.getUsername())
                .build();
        userRepository.save(user);

    }
}
