package com.dbc.desafioback.controller;

import com.dbc.desafioback.domain.agenda.Agenda;
import com.dbc.desafioback.dtos.AgendaDTO;
import com.dbc.desafioback.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody AgendaDTO agendaDTO){
        Agenda agenda = this.agendaService.createAgenda(agendaDTO);
        return new ResponseEntity<>(agenda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> getAllAgendas(){
        List<Agenda> agendas = this.agendaService.getAllAgendas();
        return new ResponseEntity<>(agendas, HttpStatus.OK);
    }
}
