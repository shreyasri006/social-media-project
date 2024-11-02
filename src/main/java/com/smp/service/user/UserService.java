package com.smp.service.user;

import com.smp.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public User registerUser(User user) {
        return user;
    }

    @Override
    public String authenticateUser(String userId, String password) {
        return "";
    }

    @Override
    public void updateProfile(User user) {

    }

    @Override
    public void uploadProfileImage(String userId, byte[] picture) {

    }

    @Override
    public List<User> getUserByName(String name, int page, int size) {
        return List.of();
    }

    @Override
    public User getUser(String userId) {
        return null;
    }
}
