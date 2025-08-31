package com.portafolio.portafolio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.portafolio.entities.Message;
import com.portafolio.portafolio.enums.MessageStatus;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByStatus(MessageStatus status);

    List<Message> findByEmail(String email);

    List<Message> findByContenidoContainingIgnoreCase(String contenido);

}
