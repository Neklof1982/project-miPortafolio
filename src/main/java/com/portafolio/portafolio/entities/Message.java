package com.portafolio.portafolio.entities;

import java.time.LocalDateTime;

import com.portafolio.portafolio.enums.MessageStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nombre;
    private String email;
    private String contenido;
    private LocalDateTime fechaEnvio;
    private MessageStatus status;

}