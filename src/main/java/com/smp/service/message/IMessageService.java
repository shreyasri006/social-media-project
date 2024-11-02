package com.smp.service.message;

import com.smp.domain.Message;
import com.smp.domain.User;

import java.util.List;

public interface IMessageService {
    String sendMessage(String senderId, String recieverId, String content, byte[] photo);
    void deleteMessage(String senderId, String messageId);
    List<Message> listMessages(String senderId, int page, int size);
}
