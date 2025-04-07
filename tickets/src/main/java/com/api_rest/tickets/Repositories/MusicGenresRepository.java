package com.api_rest.tickets.Repositories;

import com.api_rest.tickets.Entities.music_genres_entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicGenresRepository extends JpaRepository<music_genres_entity, Integer> {

    @Override
    Page<music_genres_entity> findAll(Pageable pageable);
}

