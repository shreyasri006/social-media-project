package com.smp.service.friends;

import com.smp.domain.User;

import java.util.List;

public interface IFriendsService {
    void addFriend(String userId, String friendId);

    void removeFriend(String userId, String friendId);

    void blockFriend(String userId, String friendId);

    void unblockFriend(String userId, String friendId);

    User getFriendByFriendId(String friendId);

    List<User> getFriendsByName(String name, int page, int size);

    List<User> getAllFriends(int page, int size);
}
