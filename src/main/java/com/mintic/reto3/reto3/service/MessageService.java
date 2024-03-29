package com.mintic.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Message;
import com.mintic.reto3.reto3.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> consult = messageRepository.getMessage(message.getIdMessage());
            if (consult.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> consult = messageRepository.getMessage(message.getIdMessage());
            if (!consult.isEmpty()) {
                if (message.getMessageText() != null) {
                    consult.get().setMessageText(message.getMessageText());
                }
                if (message.getClient() != null) {
                    consult.get().setClient(message.getClient());
                }
                return messageRepository.save(consult.get());
            }
        }
        return message;
    }

    public boolean deleteMessage(int id){
        Optional<Message> consult = messageRepository.getMessage(id);
            if (!consult.isEmpty()) {
                messageRepository.delete(consult.get());
                return true;
            }
        return false;
    }
}
