package com.Todo.backend.service;

import com.Todo.backend.domain.User;
import com.Todo.backend.exception.AlreadyExistsEmail;
import com.Todo.backend.exception.UserNotFound;
import com.Todo.backend.repository.UserRepository;
import com.Todo.backend.request.user.UserEdit;
import com.Todo.backend.request.user.SignUp;
import com.Todo.backend.response.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public UserResponse getUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

       return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    @Transactional
    public void editUser(Long id , UserEdit userEdit){
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            throw new UserNotFound();
        }
        User user = User.builder()
                .email(userEdit.getEmail())
                .password(userEdit.getPassword())
                .username(userEdit.getUsername())
                .build();
        userRepository.save(user);
    }

}
