package com.api_rest.tickets.Repositories;

import com.api_rest.tickets.Entities.band_entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends JpaRepository<band_entity, Integer> {

    Page<band_entity> findAllByBandNameContaining(String bandName, Pageable pageable);

    @Override
    Page<band_entity> findAll(Pageable pageable);
}

