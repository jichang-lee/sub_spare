package com.Todo.backend.controller;

import com.Todo.backend.domain.User;
import com.Todo.backend.repository.UserRepository;
import com.Todo.backend.request.user.SignUp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @AfterEach
    void clean(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입 성공")
    void test1() throws Exception{
        //given
        SignUp signUp = SignUp.builder()
                .email("jccc23@naver.com")
                .password("pass1")
                .username("이지창")
                .build();
        String json = objectMapper.writeValueAsString(signUp);

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/user/signup")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        //then
        assertEquals(1,userRepository.count());
        User user = userRepository.findAll().get(0);
        assertEquals("jccc23@naver.com",user.getEmail());
        assertTrue(passwordEncoder.matches("pass1",user.getPassword()));
        assertEquals("이지창",user.getUsername());

    }

}