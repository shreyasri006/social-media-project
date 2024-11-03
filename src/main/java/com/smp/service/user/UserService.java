package com.smp.service.user;

import ch.qos.logback.core.util.StringUtil;
import com.smp.domain.User;
import com.smp.repository.user.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistException, InvalidUserException {
        // TODO add validations here
        if (StringUtil.isNullOrEmpty(user.getUserName()) || StringUtil.isNullOrEmpty(user.getPassword())
                || StringUtil.isNullOrEmpty(user.getEmail()) || StringUtil.isNullOrEmpty(user.getFirstName())
                || StringUtil.isNullOrEmpty(user.getLastName())) {
            throw new InvalidUserException("UserName, Password, FirstName, LastName, Email are Mandatory");
        }

        user.setUserName(user.getUserName().toLowerCase());
        user.setEmail(user.getEmail().toLowerCase());

        List<User> existingUsers = userRepository.findByEmailOrUserName(user.getEmail(), user.getUserName());
        if (!existingUsers.isEmpty()) {
            throw new UserAlreadyExistException("User already exists");
        }

        Date date = new Date();
        user.setCreatedAt(date);
        user.setUpdatedAt(date);

        userRepository.insert(user);
        return user;
    }

    @Override
    public User authenticateUser(String userId, String password) {
        return null;
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
