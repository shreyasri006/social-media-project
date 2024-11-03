package com.smp.repository.user;

import com.smp.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IUserRepository extends MongoRepository<User, String> {
    // Define custom query methods if needed, e.g.,
    //Optional<User> findByUserName(String userName);
    List<User> findByEmailOrUserName(String email, String userName);
}
