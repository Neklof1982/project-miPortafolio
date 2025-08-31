package com.portafolio.portafolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.portafolio.entities.Message;
import com.portafolio.portafolio.enums.MessageStatus;
import com.portafolio.portafolio.repository.MessageRepository;
import com.portafolio.portafolio.services.MessageService;

@RestController
@CrossOrigin("*")
public class MensajeController {

    private final MessageRepository messageRepository;
    private final MessageService messageService;

    public MensajeController(MessageRepository messageRepository, MessageService messageService) {
        this.messageRepository = messageRepository;
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<Message> listarMessage() {
        return messageRepository.findAll();

    }

    @GetMapping("/messages/status/{status}")
    public List<Message> listarMessagePorStatus(@PathVariable("status") MessageStatus messageStatus) {
        return messageRepository.findByStatus(messageStatus);
    }
}
