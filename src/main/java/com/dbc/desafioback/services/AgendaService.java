package com.dbc.desafioback.services;

import com.dbc.desafioback.domain.agenda.Agenda;
import com.dbc.desafioback.dtos.AgendaDTO;
import com.dbc.desafioback.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda findAgendaById(Long id) throws Exception {
        return this.agendaRepository.findAgendaById(id).orElseThrow(() -> new Exception("Pauta não encontrada"));
    }

    public Agenda createAgenda(AgendaDTO agendaDTO){
        Agenda agenda = new Agenda(agendaDTO);
        this.saveAgenda(agenda);
        return agenda;
    }

    public void saveAgenda(Agenda agenda){this.agendaRepository.save(agenda);}

    public List<Agenda> getAllAgendas(){ return this.agendaRepository.findAll();}
}
