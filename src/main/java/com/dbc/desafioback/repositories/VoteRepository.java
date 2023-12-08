package com.dbc.desafioback.repositories;

import com.dbc.desafioback.domain.vote.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
