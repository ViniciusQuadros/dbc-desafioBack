package com.dbc.desafioback.repositories;

import com.dbc.desafioback.domain.agenda.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    Optional<Agenda> findAgendaById(Long id);
}
