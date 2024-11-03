package com.smp.repository.friends;

import com.smp.domain.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IFriendsRepository extends MongoRepository<Friend, String> {
}
