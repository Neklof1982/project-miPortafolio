package com.portafolio.portafolio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.portafolio.dtos.NewMessageDto;
import com.portafolio.portafolio.entities.Message;
import com.portafolio.portafolio.enums.MessageStatus;
import com.portafolio.portafolio.repository.MessageRepository;
import com.portafolio.portafolio.services.MessageService;

/**
 * Controlador REST para manejar las solicitudes de mensajes.
 */
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

    @GetMapping("messages/{id}")
    public Message obtenerMessagePorId(@PathVariable("id") Long id) {
        return messageService.getById(id);
    }

    @GetMapping("/messages/status/{status}")
    public List<Message> listarMessagePorStatus(@PathVariable("status") MessageStatus messageStatus) {
        return messageRepository.findByStatus(messageStatus);
    }

    @GetMapping("/messages/email/{email}")
    public List<Message> listarMessagePorEmail(@PathVariable("email") String email) {
        return messageRepository.findByEmail(email);

    }

    @GetMapping("/messages/contenido/{contenido}")
    public List<Message> listarMessagePorContenido(@PathVariable("contenido") String contenido) {
        return messageRepository.findByContenidoContainingIgnoreCase(contenido);
    }

    @PutMapping("/messages/{id}/status")
    public Message actualizarStatus(@PathVariable("id") Long id, @RequestBody MessageStatus status) {
        return messageService.updateStatus(status, id);
    }

    @PostMapping("/messages")
    public Message crearMessage(@RequestBody NewMessageDto newMessageDto) {
        return messageService.createMessage(newMessageDto);
    }
}
