package com.api_rest.tickets.Repositories;

import com.api_rest.tickets.Entities.cities_entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<cities_entity, Integer> {

    Page<cities_entity> findAllByNameContaining(String name, Pageable pageable);

    @Override
    Page<cities_entity> findAll(Pageable pageable);
}

