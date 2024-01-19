package com.Todo.backend.service;

import com.Todo.backend.domain.User;
import com.Todo.backend.exception.AlreadyExistsEmail;
import com.Todo.backend.repository.UserRepository;
import com.Todo.backend.request.user.SignUp;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @AfterEach
    void clean(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입")
    void test1(){
        //given
        SignUp signUp = SignUp.builder()
                .email("jccc23@naver.com")
                .password("pass12")
                .username("이지창")
                .build();

        //when
        userService.Signup(signUp);

        //then
        User user = userRepository.findAll().iterator().next();
        assertEquals(1 , userRepository.count());
        assertEquals("jccc23@naver.com",user.getEmail());
        assertTrue(passwordEncoder.matches("pass12",user.getPassword()));
        assertEquals("이지창",user.getUsername());
    }

    @Test
    @DisplayName("회원가입 시 이메일 중복")
    void test2(){
        User user = User.builder()
                .email("jccc23@naver.com")
                .password("pass13")
                .username("이지창")
                .build();
        userRepository.save(user);

        //given
        SignUp signUp = SignUp.builder()
                .email("jccc23@naver.com")
                .password("pass13")
                .username("이지창")
                .build();
        //expected
        assertThrows(AlreadyExistsEmail.class,()-> userService.Signup(signUp));
    }

}