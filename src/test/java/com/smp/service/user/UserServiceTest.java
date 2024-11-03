package com.smp.service.user;

import com.smp.domain.User;
import com.smp.repository.user.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setUp() {
        // Initialize a test user
        user = new User();
        user.setUserName("testUser");
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        user.setEmail("test@example.com");
        user.setPassword("password");
    }

    @Test
    public void registerUser_Success() throws UserAlreadyExistException, InvalidUserException {
        // Setup: No existing user with the same email or username
        when(userRepository.findByEmailOrUserName(any(), any())).thenReturn(Collections.emptyList());

        // Act
        User registeredUser = userService.registerUser(user);

        // Assert
        assertNotNull(registeredUser);
        assertEquals(user.getUserName().toLowerCase(), registeredUser.getUserName());
        assertEquals(user.getEmail().toLowerCase(), registeredUser.getEmail());
        assertNotNull(registeredUser.getCreatedAt());
        assertNotNull(registeredUser.getUpdatedAt());

        // Verify that the save method was called once
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void registerUser_UserAlreadyExists() {
        // Setup: Mock that a user with the same email or username already exists
        when(userRepository.findByEmailOrUserName(any(), any())).thenReturn(List.of(user));

        // Act & Assert
        assertThrows(UserAlreadyExistException.class, () -> userService.registerUser(user));

        // Verify that save was never called due to exception
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void registerUser_InvalidUser_Missing_Email() {
        // Setup: Set invalid fields in the user (e.g., missing email)
        user.setEmail(null);

        // Act & Assert
        assertThrows(InvalidUserException.class, () -> userService.registerUser(user));

        // Verify that findByEmailOrUserName and save were never called
        verify(userRepository, never()).findByEmailOrUserName(anyString(), anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void registerUser_InvalidUser_Missing_Password() {
        // Setup: Set invalid fields in the user (e.g., missing email)
        user.setPassword(null);

        // Act & Assert
        assertThrows(InvalidUserException.class, () -> userService.registerUser(user));

        // Verify that findByEmailOrUserName and save were never called
        verify(userRepository, never()).findByEmailOrUserName(anyString(), anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void registerUser_InvalidUser_Missing_UserName() {
        // Setup: Set invalid fields in the user (e.g., missing email)
        user.setUserName(null);

        // Act & Assert
        assertThrows(InvalidUserException.class, () -> userService.registerUser(user));

        // Verify that findByEmailOrUserName and save were never called
        verify(userRepository, never()).findByEmailOrUserName(anyString(), anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void registerUser_InvalidUser_Missing_FirstName() {
        // Setup: Set invalid fields in the user (e.g., missing email)
        user.setFirstName(null);

        // Act & Assert
        assertThrows(InvalidUserException.class, () -> userService.registerUser(user));

        // Verify that findByEmailOrUserName and save were never called
        verify(userRepository, never()).findByEmailOrUserName(anyString(), anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void registerUser_InvalidUser_Missing_LastName() {
        // Setup: Set invalid fields in the user (e.g., missing email)
        user.setLastName(null);

        // Act & Assert
        assertThrows(InvalidUserException.class, () -> userService.registerUser(user));

        // Verify that findByEmailOrUserName and save were never called
        verify(userRepository, never()).findByEmailOrUserName(anyString(), anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    //@Test TODO will be uncommented once we have authenticate method is implemented
    public void authenticateUser_success() {
        // Act
        User user = userService.authenticateUser("username", "password");

        // Assert
        assertNotNull(user);
    }
}
