package com.ertedemo.shared.services.impl;

import com.ertedemo.domain.model.entites.Message;
import com.ertedemo.domain.model.entites.Tenant;
import com.ertedemo.domain.model.entites.User;
import com.ertedemo.domain.persistence.MessageRepository;
import com.ertedemo.domain.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    MessageRepository messageRepository;


    @Override
    public Optional<Message> getById(Long messageId) {
        return Optional.ofNullable(messageRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("Message nor found")));
    }

    @Override
    public void create(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getByRecipient(Tenant recipient) {
        return messageRepository.findByRecipient(recipient);
    }

}
