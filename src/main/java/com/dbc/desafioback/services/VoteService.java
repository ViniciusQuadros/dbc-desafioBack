package com.dbc.desafioback.services;

import com.dbc.desafioback.domain.agenda.Agenda;
import com.dbc.desafioback.domain.user.User;
import com.dbc.desafioback.domain.vote.Vote;
import com.dbc.desafioback.dtos.VoteDto;
import com.dbc.desafioback.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private UserService userService;

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private VoteRepository voteRepository;

    public void createVote(VoteDto voteDto) throws Exception{

        Agenda agenda = agendaService.findAgendaById(voteDto.agendaId());
        User user = userService.findUserById(voteDto.voterId());

        boolean hasUserAlreadyVoted = agenda.getVotes().stream().anyMatch(vote -> vote.getVoter().getId() == voteDto.voterId() && vote.getAgenda().getId() == voteDto.agendaId());

        if(hasUserAlreadyVoted){
            throw new Exception("Usuário já votou nessa pauta");
        }

        userService.validateVotingUser(user);

        Vote vote = new Vote(user, agenda, voteDto.voteValue());
        agenda.getVotes().add(vote);

        this.voteRepository.save(vote);
        this.agendaService.saveAgenda(agenda);
    }
}
