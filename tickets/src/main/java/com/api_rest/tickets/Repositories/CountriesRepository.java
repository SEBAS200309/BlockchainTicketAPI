package com.api_rest.tickets.Repositories;

import com.api_rest.tickets.Entities.countries_entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<countries_entity, Integer> {


    @Override
    Page<countries_entity> findAll(Pageable pageable);
}

