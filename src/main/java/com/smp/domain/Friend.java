package com.smp.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "friend")
public class Friend extends Domain {
    private String userId;
    private String friendId;
    private String status; // "friends" or "blocked"

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
