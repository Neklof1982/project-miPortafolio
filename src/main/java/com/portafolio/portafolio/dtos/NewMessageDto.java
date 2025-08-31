package com.portafolio.portafolio.dtos;

import java.time.LocalDateTime;

import com.portafolio.portafolio.enums.MessageStatus;

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
