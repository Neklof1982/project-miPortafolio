package com.portafolio.backend.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portafolio.backend.dtos.NewMessageDto;
import com.portafolio.backend.entities.Message;
import com.portafolio.backend.enums.MessageStatus;
import com.portafolio.backend.exceptions.MessageNotFoundException;
import com.portafolio.backend.repository.MessageRepository;

@Service
@Transactional
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Crea un nuevo mensaje y lo guarda en la base de datos.
     *
     * @param newMessageDto El DTO que contiene los datos del mensaje a crear.
     * @return El objeto Message creado con el ID asignado automáticamente.
     */
    @Transactional
    public Message createMessage(NewMessageDto newMessageDto) {

        // Pasar el DTO a Entity
        Message message = Message.builder()
                .nombre(newMessageDto.getNombre())
                .email(newMessageDto.getEmail())
                .contenido(newMessageDto.getContenido())
                // Status por defecto
                .status(MessageStatus.RECIBIDO)
                .fechaEnvio(LocalDateTime.now())
                .build();

        // Guardar en BBDD
        return messageRepository.save(message);
    }

    /**
     * Busca un mensaje por Id.
     *
     * @param id El Id del mensaje que se busca.
     * @return El mensaje correspondiente al Id.
     * @throws MessageNotFoundException Si no se encuentra el mensaje con el Id.
     */
    public Message getById(Long id) {

        Optional<Message> optionalMessage = messageRepository.findById(id);

        if (!optionalMessage.isPresent()) {
            // Sino se encuetra mensaje lanzar exceptción personaliza
            throw new MessageNotFoundException("Mensaje con ID " + id + " no encontrado");
        }

        // Obtener el mensaje del Optional
        Message message = optionalMessage.get();

        return messageRepository.save(message);
    }

    /**
     * Actualiza el estado de un mensaje existente.
     *
     * @param status El nuevo estado que se quiere asignar al mensaje.
     * @param id     El Id del mensaje a actualizar.
     * @return El mensaje con el estado actualizado.
     * @throws MessageNotFoundException Si no se encuentra el mensaje con el Id.
     */
    @Transactional
    public Message updateStatus(MessageStatus status, Long id) {

        // Obtener el mensaje por Id
        Optional<Message> optionalMessage = messageRepository.findById(id);

        if (!optionalMessage.isPresent()) {
            // Sino se encuetra mensaje lanzar exceptción personaliza
            throw new MessageNotFoundException("Mensaje con ID " + id + " no encontrado");
        }

        // Obtener el mensaje del Optional
        Message message = optionalMessage.get();

        // Actualizar Status
        message.setStatus(status);

        return messageRepository.save(message);
    }

}
