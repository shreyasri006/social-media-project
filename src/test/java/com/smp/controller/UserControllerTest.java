package com.smp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.domain.User;
import com.smp.service.user.IUserService;
import com.smp.service.user.InvalidUserException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registerUser_Success() throws Exception {
        User mockedUser = new User();
        mockedUser.setId("123");
        mockedUser.setFirstName("John");
        mockedUser.setLastName("Doe");
        mockedUser.setEmail("john.doe@example.com");
        mockedUser.setUserName("johnDoe123");
        mockedUser.setCreatedAt(new Date());
        mockedUser.setUpdatedAt(new Date());

        when(userService.registerUser(any(User.class))).thenReturn(mockedUser);

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setUserName("johnDoe123");

        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.userName").value("johnDoe123"))
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.createdAt").isNotEmpty())
                .andExpect(jsonPath("$.updatedAt").isNotEmpty());
    }

    // @Test
    void registerUser_InvalidInput() throws Exception {
        when(userService.registerUser(any(User.class))).thenThrow(new InvalidUserException("Invalid Email Id."));

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("bla bla bla");
        user.setUserName("johnDoe123");

        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest());
    }
}
