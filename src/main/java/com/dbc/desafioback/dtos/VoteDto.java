package com.dbc.desafioback.dtos;

public record VoteDto(Long voterId, Long agendaId, boolean voteValue) {
}
