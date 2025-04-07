package com.api_rest.tickets.Repositories;

import com.api_rest.tickets.Entities.stadiums_entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumsRepository extends JpaRepository<stadiums_entity, Integer> {

    @Override
    Page<stadiums_entity> findAll(Pageable pageable);
}
