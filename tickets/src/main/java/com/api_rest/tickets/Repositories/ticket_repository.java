package com.api_rest.tickets.Repositories;

import com.api_rest.tickets.Entities.tickets_entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ticket_repository extends JpaRepository<tickets_entity, UUID> {

    Page<tickets_entity> findAllByCarMovieNameContaining(String carMovieName, Pageable pageable);

    @Override
    Page<tickets_entity> findAll(Pageable pageable);
}