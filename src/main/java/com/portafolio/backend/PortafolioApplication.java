package com.portafolio.backend;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.portafolio.backend.entities.Message;
import com.portafolio.backend.enums.MessageStatus;
import com.portafolio.backend.repository.MessageRepository;

@SpringBootApplication
public class PortafolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortafolioApplication.class, args);
	}

	// Guardar mensajes de ejemplo utilizando el patrón Builder
	@Bean
	CommandLineRunner commandLineRunner(MessageRepository messageRepository) {

		return args -> {
			messageRepository.save(Message.builder()
					.nombre("Juan")
					.email("juan@ejemplo.com")
					.contenido("Este es un primer mensaje")
					.status(MessageStatus.RECIBIDO)
					.fechaEnvio(LocalDateTime.now())
					.build());

			messageRepository.save(Message.builder()
					.nombre("Antonio")
					.email("antonio@ejemplo.com")
					.contenido("Este es un segundo mensaje")
					.status(MessageStatus.RECIBIDO)
					.fechaEnvio(LocalDateTime.now())
					.build());

			messageRepository.save(Message.builder()
					.nombre("Juan")
					.email("juan@ejemplo.com")
					.contenido("Este es un tercer mensaje")
					.status(MessageStatus.RECIBIDO)
					.fechaEnvio(LocalDateTime.now())
					.build());

		};

	}
}
