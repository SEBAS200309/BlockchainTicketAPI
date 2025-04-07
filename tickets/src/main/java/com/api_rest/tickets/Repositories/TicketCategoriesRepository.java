package com.api_rest.tickets.Repositories;

import com.api_rest.tickets.Entities.ticket_categories_entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCategoriesRepository extends JpaRepository<ticket_categories_entity, Integer> {

    @Override
    Page<ticket_categories_entity> findAll(Pageable pageable);
}