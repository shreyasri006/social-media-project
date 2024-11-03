package com.smp.repository.message;

import com.smp.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IMessageRepository extends MongoRepository<Message, String> {
    List<Message> findMessageByReceiverIdAndStatus(String receiverId, String status);
}
