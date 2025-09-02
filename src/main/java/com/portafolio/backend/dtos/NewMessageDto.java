package com.portafolio.backend.dtos;

import java.time.LocalDateTime;

import com.portafolio.backend.enums.MessageStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewMessageDto {

    private String nombre;
    private String email;
    private String contenido;
    private LocalDateTime fechaEnvio;
    private MessageStatus status;
}
