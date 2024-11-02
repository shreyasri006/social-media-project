package com.smp.service.message;

import com.smp.domain.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {
    @Override
    public String sendMessage(String senderId, String recieverId, String content, byte[] photo) {
        return "";
    }

    @Override
    public void deleteMessage(String senderId, String messageId) {

    }

    @Override
    public List<Message> listMessages(String senderId, int page, int size) {
        return List.of();
    }
}
