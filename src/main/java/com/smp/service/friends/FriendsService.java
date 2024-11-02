package com.smp.service.friends;

import com.smp.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService implements IFriendsService {
    @Override
    public void addFriend(String userId, String friendId) {

    }

    @Override
    public void removeFriend(String userId, String friendId) {

    }

    @Override
    public void blockFriend(String userId, String friendId) {

    }

    @Override
    public void unblockFriend(String userId, String friendId) {

    }

    @Override
    public User getFriendByFriendId(String friendId) {
        return null;
    }

    @Override
    public List<User> getFriendsByName(String name, int page, int size) {
        return List.of();
    }

    @Override
    public List<User> getAllFriends(int page, int size) {
        return List.of();
    }
}
