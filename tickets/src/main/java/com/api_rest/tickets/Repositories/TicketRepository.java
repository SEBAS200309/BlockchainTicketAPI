package com.api_rest.tickets.Repositories;

import com.api_rest.tickets.Entities.band_entity;
import com.api_rest.tickets.Entities.tickets_entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<tickets_entity, Integer> {

    Page<tickets_entity> findAllByNameContaining(String name, Pageable pageable);

    @Override
    Page<tickets_entity> findAll(Pageable pageable);
}
