package com.dbc.desafioback.domain.vote;

import com.dbc.desafioback.domain.agenda.Agenda;
import com.dbc.desafioback.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "vote")
@Table(name = "vote")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "voter_id")
    private User voter;
    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;
    private boolean voteValue;
    private LocalDateTime timestamp;

    public Vote(User user, Agenda agenda, boolean voteValue) {
        this.voter = user;
        this.agenda = agenda;
        this.voteValue = voteValue;
    }
}
