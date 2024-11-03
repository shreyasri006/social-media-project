package com.smp.service.user;

import com.smp.domain.User;

import java.util.List;

public interface IUserService {
    User registerUser(User user) throws UserAlreadyExistException, InvalidUserException;

    String authenticateUser(String userId, String password);

    void updateProfile(User user);

    void uploadProfileImage(String userId, byte[] picture);

    List<User> getUserByName(String name, int page, int size);

    User getUser(String userId);
}
