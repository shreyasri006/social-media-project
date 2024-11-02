package com.smp.domain;

public class Message extends Domain {
    private String senderId;
    private String receiverId;
    private String content;
    private byte[] isPhoto;
    private String status;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getIsPhoto() {
        return isPhoto;
    }

    public void setIsPhoto(byte[] isPhoto) {
        this.isPhoto = isPhoto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
