package com.dbc.desafioback.dtos;

import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;

public record AgendaDTO(String title, String description, int voteDurationTimeInMinutes) {
}
