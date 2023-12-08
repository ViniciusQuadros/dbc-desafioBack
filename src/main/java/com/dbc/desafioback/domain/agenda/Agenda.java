package com.dbc.desafioback.domain.agenda;

import com.dbc.desafioback.domain.vote.Vote;
import com.dbc.desafioback.dtos.AgendaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "agenda")
@Table(name = "agenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startVotingTimestamp;
    private LocalDateTime endVotingTimestamp;
    @OneToMany
    @JoinColumn(name = "vote_id")
    private List<Vote> votes;

    public Agenda(AgendaDTO agendaDTO) {
        this.title = agendaDTO.title();
        this.description = agendaDTO.description();
        this.startVotingTimestamp = LocalDateTime.now();
        this.endVotingTimestamp = this.startVotingTimestamp.plusMinutes(agendaDTO.voteDurationTimeInMinutes());
    }
}
